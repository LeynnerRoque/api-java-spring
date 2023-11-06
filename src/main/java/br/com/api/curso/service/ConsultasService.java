package br.com.api.curso.service;


import br.com.api.curso.records.ConsultasRecord;
import br.com.api.curso.records.dtos.DadosConsultaDTO;
import br.com.api.curso.records.mapper.ConsultasMapper;
import br.com.api.curso.repository.ConsultaRepository;
import br.com.api.curso.validations.IValidation;
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

    @Autowired
    private DadosConsultaService service;

    @Autowired
    private EmailService serviceMail;

    public DadosConsultaDTO agendarConsulta(ConsultasRecord record){
        validations.forEach(v -> v.validar(record));
        var consultas = consultasMapper.fromEntity(record);
        consultaRepository.save(consultas);

        var dadosMedico = service.buildMedico(record);
        var dadosPaciente = service.buildPaciente(record);

        serviceMail.sendMail("leynnerroque@yahoo.com.br",dadosPaciente.email(),"Consulta Marcada com Sucesso");

        return new DadosConsultaDTO(dadosMedico.nome(), dadosMedico.crm(), dadosPaciente.nome(), dadosPaciente.cpf());
    }


}
