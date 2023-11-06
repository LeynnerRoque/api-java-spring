package br.com.api.curso.records;

import jakarta.validation.constraints.NotNull;

public record ConsultasRecord(
        Long id,
        @NotNull
        Long idMedico,
        @NotNull
        Long idPaciente
) {
}
