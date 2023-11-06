package br.com.api.curso.records.mapper;

import br.com.api.curso.model.Endereco;
import br.com.api.curso.model.Medico;
import br.com.api.curso.records.EnderecoRecord;
import br.com.api.curso.records.MedicoRecord;
import br.com.api.curso.records.dtos.MedicoListagens;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MedicoMapper {

    public Medico fromEntity(MedicoRecord record){
        var medico = new Medico();
        var endereco = getEndereco(record);
        medico.setEndereco(endereco);
        BeanUtils.copyProperties(record,medico);
        return medico;
    }


    public Endereco getEndereco(MedicoRecord record){
        var endereco = new Endereco();
        BeanUtils.copyProperties(record.endereco(), endereco);
        return endereco;
    }

    public EnderecoRecord getEnderecoRecord(Medico medico){
        var record = new EnderecoRecord(
                medico.getEndereco().getLogradouro(),
                medico.getEndereco().getBairro(),
                medico.getEndereco().getCep(),
                medico.getEndereco().getCidade(),
                medico.getEndereco().getUf(),
                medico.getEndereco().getComplemento(),
                medico.getEndereco().getNumero()
        );

        return record;
    }

    public MedicoRecord toRecord(Medico medico){
        var record = new MedicoRecord(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                getEnderecoRecord(medico)
                );
        return record;
    }

    public MedicoListagens toRecordList(Medico medico){
        var record = new MedicoListagens(
                medico.getNome(),
                medico.getEmail(),
                medico.getEspecialidade(),
                medico.getEndereco().getLogradouro());
        return record;
    }

    public List<MedicoRecord> toListRecord(List<Medico> medicos){
        return medicos.stream()
                .filter(Objects::nonNull)
                .map(this::toRecord)
                .collect(Collectors.toList());
    }

    public List<MedicoListagens> toRecordListagem(List<Medico> medicos){
        return medicos.stream()
                .filter(Objects::nonNull)
                .map(this::toRecordList)
                .collect(Collectors.toList());
    }

}
