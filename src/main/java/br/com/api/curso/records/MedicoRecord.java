package br.com.api.curso.records;

import br.com.api.curso.records.utils.Especialidades;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRecord (

        @NotNull
        Long id,

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidades especialidade,
        @NotNull
        @Valid
        EnderecoRecord endereco) {
}
