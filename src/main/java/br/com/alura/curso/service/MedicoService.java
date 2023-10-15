package br.com.alura.curso.service;

import br.com.alura.curso.records.dtos.MedicoListagens;
import br.com.alura.curso.records.mapper.MedicoMapper;
import br.com.alura.curso.model.Medico;
import br.com.alura.curso.records.MedicoRecord;
import br.com.alura.curso.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoMapper mapper;

    @Transactional
    public void create(MedicoRecord record){
        Medico medico = mapper.fromEntity(record);
        repository.save(medico);
    }


    public List<MedicoRecord> getall(){
    List<Medico> lista = repository.findAll();
    List<MedicoRecord> records = mapper.toListRecord(lista);
        return  records;
    }

    public List<MedicoListagens> getallFormated(){
        List<Medico> lista = repository.findAll( );
        List<MedicoListagens> records = mapper.toRecordListagem(lista);
        return  records;
    }

    public Page<Medico> pageMedicos(Pageable page){
        return repository.findAll(page);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public MedicoRecord getOne(Integer id){
        Medico medico = repository.findById(id);
        return mapper.toRecord(medico);
    }

    public MedicoRecord update(MedicoRecord record){
        if(record.id() < 0){
            return null;
        }else{
            Medico medico = mapper.fromEntity(record);
            return mapper.toRecord(repository.save(medico));
        }
    }
}
