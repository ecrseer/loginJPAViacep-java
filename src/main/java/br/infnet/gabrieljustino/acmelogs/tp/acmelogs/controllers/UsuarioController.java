package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.controllers;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.UsuarioRepository;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.ViacepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuario")
@EnableFeignClients(basePackages = "br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository")
public class UsuarioController {
    private String KEY_SESSAO_USUARIO = new UsuarioComEndereco().getKey();
    private String KEY_CADASTRANDO_USUARIO = new UsuarioComEndereco().getCadastrandoKey();

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ViacepRepository viacepRepository;

    @GetMapping("/logar")
    public String logar() {
        return "login/login";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "login/cadastrar";
    }

    @PostMapping("/logar")
    public String entrar(UsuarioComEndereco usuarioComEndereco, HttpServletRequest request) {
        var reqSession = request.getSession();

        try {
            var resultSavedUsuario = usuarioRepository.findUsuarioByEmail(usuarioComEndereco.getEmail());
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

    @PostMapping("/cadastroPesquisaCep")
    public String cadastroPesquisaCep(UsuarioComEndereco usuario, HttpServletRequest request) {
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
    public String publicarUsuario(UsuarioComEndereco usuarioComEndereco) {
        var resultSavedUsuario = usuarioRepository.save(usuarioComEndereco);
        System.out.println(resultSavedUsuario);
        return "login/cadastrar";
    }


}
