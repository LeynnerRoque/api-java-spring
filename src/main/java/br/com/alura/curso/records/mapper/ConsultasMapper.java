package br.com.alura.curso.records.mapper;

import br.com.alura.curso.model.Consultas;
import br.com.alura.curso.records.ConsultasRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConsultasMapper {

    public Consultas fromEntity(ConsultasRecord record){
        var consultas = new Consultas();
        BeanUtils.copyProperties(record,consultas);
        return consultas;
    }
}
