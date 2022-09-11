package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.dtos.iMyWebDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class UsuarioComEndereco extends Endereco implements Serializable, iMyWebDto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private String name;
    private String email;
    private String password;
    private String telefone;
    private String numeroEndereco;

    public void setEndereco(Endereco endereco) {
        this.setCep(endereco.getCep());
        this.setLogradouro(endereco.getLogradouro());
        this.setComplemento(endereco.getComplemento());
        this.setBairro(endereco.getBairro());
        this.setLocalidade(endereco.getLocalidade());
        this.setUf(endereco.getUf());
        this.setIbge(endereco.getIbge());
        this.setGia(endereco.getGia());
        this.setDdd(endereco.getDdd());
        this.setSiafi(endereco.getSiafi());
    }

    public UsuarioComEndereco makeClone() {
        var context = new UsuarioComEndereco(getIdUsuario(), getName(), getEmail(),
                getPassword(), getTelefone(),
                getNumeroEndereco());
        context.setEndereco(super.makeClone());
        return context;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getKey() {
        return "loggedUser";
    }

    public String getCadastrandoKey() {
        return "registeringUser";
    }
}
