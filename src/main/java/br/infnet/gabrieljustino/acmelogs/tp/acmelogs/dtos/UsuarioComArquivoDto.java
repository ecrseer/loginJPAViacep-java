package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.dtos;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.Endereco;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioComArquivoDto extends UsuarioComEndereco {
    MultipartFile profilePic;

}
