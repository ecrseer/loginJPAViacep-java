package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.controllers;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.Usuario;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuario")
@EnableFeignClients()
public class UsuarioController {
    private String KEY_SESSAO_USUARIO = new Usuario().getKey();

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/cadastrar")
    public String inserir() {

        return "login/cadastrar";
    }

    @GetMapping("/logar")
    public String logar() {
        return "login/login";
    }

    @PostMapping("/logar")
    public String entrar(Usuario usuario, HttpServletRequest request) {
        var reqSession = request.getSession();

        try {
            var resultSavedUsuario = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
            if (usuario.getPassword().equals(resultSavedUsuario.getPassword())) {
                System.out.println(resultSavedUsuario);
                reqSession.setAttribute(KEY_SESSAO_USUARIO, resultSavedUsuario);
            } else{
                reqSession.setAttribute("senhaErrada",true);
            }

        } catch (Exception err) {
            return err.getMessage();
        }

        return "login/login";
    }


    @PostMapping("/cadastrar")
    public String publicarUsuario(Usuario usuario) {
        var resultSavedUsuario = usuarioRepository.save(usuario);

        System.out.println(resultSavedUsuario);
        return "login/cadastrar";
    }


}
