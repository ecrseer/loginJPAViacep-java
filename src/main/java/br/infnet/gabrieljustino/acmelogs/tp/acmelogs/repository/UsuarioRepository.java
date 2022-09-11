package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioComEndereco, Long> {
    UsuarioComEndereco findUsuarioByEmail(String email);
}
