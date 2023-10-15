package br.com.alura.curso.records;

import br.com.alura.curso.records.utils.UF;
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
