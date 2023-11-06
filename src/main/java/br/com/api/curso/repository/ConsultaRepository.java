package br.com.api.curso.repository;

import br.com.api.curso.model.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consultas,Long> {
}
