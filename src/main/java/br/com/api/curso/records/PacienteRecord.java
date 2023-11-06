package br.com.api.curso.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record PacienteRecord(
        Long id,
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String cpf) {
}
