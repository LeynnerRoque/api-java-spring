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
        //TODO
        //Retornar dados do paciente e do medico
        //campo data para marcar consulta
        //nao pode marcar em sabado e domingo ate 30 minutos antes das 8 as 19
        validations.forEach(v -> v.validar(record));
        var consultas = consultasMapper.fromEntity(record);
        consultaRepository.save(consultas);
    }
}
