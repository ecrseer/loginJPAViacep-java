package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findUsuarioByEmail(String email);
}
