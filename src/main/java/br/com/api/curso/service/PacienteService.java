package br.com.api.curso.service;

import br.com.api.curso.model.Paciente;
import br.com.api.curso.records.PacienteRecord;
import br.com.api.curso.records.mapper.PacienteMapper;
import br.com.api.curso.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private PacienteMapper mapper;

    @Transactional
    public void create(PacienteRecord record) {
        var paciente = mapper.fromEntity(record);
        repository.save(paciente);
    }

    //TODO
    //update

    public List<PacienteRecord> getAll(){
        return mapper.toRecordList(repository.findAll());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public PacienteRecord update(PacienteRecord record){
        if(record.id() < 0){
            return null;
        }
        Paciente paciente = mapper.fromEntity(record);
        return mapper.toRecord(paciente);
    }
}
