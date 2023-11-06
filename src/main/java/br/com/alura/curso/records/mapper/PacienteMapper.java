package br.com.alura.curso.records.mapper;

import br.com.alura.curso.model.Paciente;
import br.com.alura.curso.records.PacienteRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PacienteMapper {

    public Paciente fromEntity(PacienteRecord record){
        var paciente = new Paciente();
        BeanUtils.copyProperties(record,paciente);
        return paciente;
    }

    public PacienteRecord toRecord(Paciente paciente){
        var record = new PacienteRecord(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf()
        );
        return record;
    }

    public List<PacienteRecord> toRecordList(List<Paciente> pacientes){
        return  pacientes.stream()
                .filter(Objects::nonNull)
                .map(this::toRecord)
                .collect(Collectors.toList());
    }

}
