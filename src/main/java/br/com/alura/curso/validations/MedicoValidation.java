package br.com.alura.curso.validations;

import br.com.alura.curso.model.Medico;
import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.records.MedicoRecord;
import br.com.alura.curso.records.dtos.MedicoDTO;
import br.com.alura.curso.repository.MedicoRepository;
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
