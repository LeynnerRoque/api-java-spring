package br.com.alura.curso.service;

import br.com.alura.curso.records.PacienteRecord;
import br.com.alura.curso.records.mapper.PacienteMapper;
import br.com.alura.curso.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    //update, delete, listAll
}
