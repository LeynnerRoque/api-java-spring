package br.com.alura.curso.service;

import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.records.mapper.ConsultasMapper;
import br.com.alura.curso.repository.ConsultaRepository;
import br.com.alura.curso.repository.MedicoRepository;
import br.com.alura.curso.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultasMapper consultasMapper;

    public void agendarConsulta(ConsultasRecord record){

        if(!pacienteRepository.existsById(record.idPaciente())){
            throw new RuntimeException("Erro ao buscar paciente");
        }

        if(!medicoRepository.existsById(record.idMedico())){
            throw new RuntimeException("Erro ao buscar Medico");
        }
        //Se fosse guardar as entidades.Como e so o id, passa direto
       // var paciente = pacienteRepository.findById(record.idPaciente());
       // var medico = medicoRepository.findById(record.idMedico());

        var consultas = consultasMapper.fromEntity(record);
        consultaRepository.save(consultas);
    }
}
