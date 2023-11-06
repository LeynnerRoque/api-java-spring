package br.com.api.curso.validations;

import br.com.api.curso.records.ConsultasRecord;
import br.com.api.curso.repository.PacienteRepository;
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
