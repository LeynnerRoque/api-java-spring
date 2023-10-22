package br.com.alura.curso.validations;

import br.com.alura.curso.model.Medico;
import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.records.dtos.PacienteDTO;
import br.com.alura.curso.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteValidation implements IValidation{

    @Autowired
    private PacienteRepository repository;

    @Override
    public void validar(ConsultasRecord record) {
        if(!repository.existsById(record.idPaciente())){
            throw new RuntimeException("Erro ao buscar paciente");
        }
    }
}
