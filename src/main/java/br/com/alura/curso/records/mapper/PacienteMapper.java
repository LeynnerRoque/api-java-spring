package br.com.alura.curso.records.mapper;

import br.com.alura.curso.model.Paciente;
import br.com.alura.curso.records.PacienteRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PacienteMapper {

    public Paciente fromEntity(PacienteRecord record){
        var paciente = new Paciente();
        BeanUtils.copyProperties(record,paciente);
        return paciente;
    }
}
