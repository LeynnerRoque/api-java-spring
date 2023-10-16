package br.com.alura.curso.repository;

import br.com.alura.curso.model.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consultas,Long> {
}
