package br.com.api.curso.records.dtos;

import br.com.api.curso.records.utils.Especialidades;

public record MedicoListagens(String nome, String email, Especialidades especialidade, String local) {
}
