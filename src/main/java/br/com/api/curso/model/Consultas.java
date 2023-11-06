package br.com.api.curso.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "consultas")
@Entity(name = "Consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long idMedico;

    private Long idPaciente;
}
