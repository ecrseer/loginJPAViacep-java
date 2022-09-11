package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        url = "https://viacep.com.br/ws/",
        name = "ViacepRepository")
public interface ViacepRepository {

    @GetMapping("{cep}/json")
    Endereco buscarEnderecoPorCep(
            @PathVariable("cep") String cep);
}
