package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.controllers;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.dtos.UsuarioComArquivoDto;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.UsuarioRepository;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.ViacepRepository;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuario")
@EnableFeignClients(basePackages = "br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository")
public class UsuarioController {
    private String KEY_SESSAO_USUARIO = new UsuarioComEndereco().getKey();
    private String KEY_CADASTRANDO_USUARIO = new UsuarioComEndereco().getCadastrandoKey();

    /*@Autowired
    UsuarioRepository usuarioRepository;*/

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ViacepRepository viacepRepository;

    @GetMapping("/logar")
    public String logar() {
        return "login/login";
    }

    @GetMapping("/registrar")
    public String registrar(HttpServletRequest request) {
        request.getSession().setAttribute(KEY_CADASTRANDO_USUARIO, null);
        return "login/cadastrar";
    }

    @PostMapping("/logar")
    public String entrar(UsuarioComEndereco usuarioComEndereco, HttpServletRequest request) {
        var reqSession = request.getSession();

        try {
            var resultSavedUsuario = usuarioService.findUsuarioByEmail(usuarioComEndereco.getEmail());
            if (usuarioComEndereco.getPassword().equals(resultSavedUsuario.getPassword())) {
                System.out.println(resultSavedUsuario);
                reqSession.setAttribute(KEY_SESSAO_USUARIO, resultSavedUsuario);
            } else {
                reqSession.setAttribute("senhaErrada", true);
            }

        } catch (Exception err) {
            return err.getMessage();
        }
        return "login/login";
    }

    @PostMapping(value = "/cadastroPesquisaCep")
    public String cadastroPesquisaCep(@ModelAttribute UsuarioComArquivoDto usuario, HttpServletRequest request) {
        var session = request.getSession();
        session.setAttribute(KEY_CADASTRANDO_USUARIO, null);
        try {
            var responseEndereco = viacepRepository.buscarEnderecoPorCep(usuario.getCep());
            usuario.setEndereco(responseEndereco);
            session.setAttribute(KEY_CADASTRANDO_USUARIO, usuario);
        } catch (Exception err) {
            err.printStackTrace();
        }
        return "login/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String publicarUsuario(@ModelAttribute UsuarioComArquivoDto dto,
                                  HttpServletRequest request) {

        UsuarioComEndereco usuario = dto.makeClone();
        var resultSavedUsuario = usuarioService.save(usuario);

        var session = request.getSession();
        var result = usuarioService.editUser(usuario, dto.getProfilePic());


        request.setAttribute("cadastrado", usuario);
        session.setAttribute(KEY_CADASTRANDO_USUARIO, null);

        if(usuarioService.loadUser(usuario)){
            return "login/cadastrar";
        }
        return "login/cadastrar";
    }


}
