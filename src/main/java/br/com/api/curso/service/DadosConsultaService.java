package br.com.api.curso.service;

import br.com.api.curso.records.ConsultasRecord;
import br.com.api.curso.records.dtos.MedicoDTO;
import br.com.api.curso.records.dtos.PacienteDTO;
import br.com.api.curso.repository.MedicoRepository;
import br.com.api.curso.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosConsultaService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public MedicoDTO buildMedico(ConsultasRecord record){
        var medico = medicoRepository.findById(record.idMedico()).get();
        return new MedicoDTO(medico.getNome(), medico.getCrm());
    }

    public PacienteDTO buildPaciente(ConsultasRecord record){
        var paciente = pacienteRepository.findById(record.idPaciente()).get();
        return new PacienteDTO(paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}
