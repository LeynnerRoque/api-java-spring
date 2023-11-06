package br.com.api.curso.records.mapper;

import br.com.api.curso.model.Consultas;
import br.com.api.curso.records.ConsultasRecord;
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
