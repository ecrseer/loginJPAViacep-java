package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Endereco makeClone() {
        return new Endereco(getCep(), getLogradouro(), getComplemento(), getBairro(),
                getLocalidade(), getUf(), getIbge(), getGia(), getDdd(), getSiafi());
    }

}
