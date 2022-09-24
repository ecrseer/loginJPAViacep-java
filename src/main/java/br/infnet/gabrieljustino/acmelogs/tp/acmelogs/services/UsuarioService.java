package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.services;


import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    final String DEFAULT_BUCKET = "gabecrbuck";

    @Autowired
    UsuarioRepository usuarioRepository;



    public UsuarioComEndereco findUsuarioByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }

    public UsuarioComEndereco salvar(UsuarioComEndereco usuario) {
        return this.usuarioRepository.save(usuario);
    }


}
