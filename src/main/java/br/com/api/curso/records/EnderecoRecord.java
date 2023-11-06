package br.com.api.curso.records;

import br.com.api.curso.records.utils.UF;
import jakarta.validation.constraints.NotBlank;

public record EnderecoRecord(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        UF uf,
        String complemento ,
        String numero) {
}
