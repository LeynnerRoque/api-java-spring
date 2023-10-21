package br.com.alura.curso.service;

import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.records.mapper.ConsultasMapper;
import br.com.alura.curso.repository.ConsultaRepository;
import br.com.alura.curso.repository.MedicoRepository;
import br.com.alura.curso.repository.PacienteRepository;
import br.com.alura.curso.validations.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultasMapper consultasMapper;

    @Autowired
    private List<IValidation> validations;

    public void agendarConsulta(ConsultasRecord record){
        validations.forEach(v -> v.validar(record));
        var consultas = consultasMapper.fromEntity(record);
        consultaRepository.save(consultas);
    }
}
