package br.com.alura.curso.records.dtos;

import br.com.alura.curso.records.utils.Especialidades;

public record MedicoListagens(String nome, String email, Especialidades especialidade, String local) {
}
