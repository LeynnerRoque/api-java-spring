package br.com.api.curso.validations;

import br.com.api.curso.records.ConsultasRecord;
import br.com.api.curso.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoValidation implements IValidation{
    @Autowired
    private MedicoRepository repository;
    @Override
    public void validar(ConsultasRecord record) {
        if(!repository.existsById(record.idMedico())){
            throw new RuntimeException("Erro ao buscar Medico");
        }
    }
}
