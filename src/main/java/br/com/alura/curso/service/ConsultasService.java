package br.com.alura.curso.service;

import br.com.alura.curso.configs.MailSend;
import br.com.alura.curso.model.Medico;
import br.com.alura.curso.records.ConsultasRecord;
import br.com.alura.curso.records.dtos.DadosConsultaDTO;
import br.com.alura.curso.records.mapper.ConsultasMapper;
import br.com.alura.curso.repository.ConsultaRepository;
import br.com.alura.curso.validations.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    public DadosConsultaDTO agendarConsulta(ConsultasRecord record){
        //TODO
        //campo data para marcar consulta
        //nao pode marcar em sabado e domingo ate 30 minutos antes das 8 as 19
        //Enviar e-mail
        validations.forEach(v -> v.validar(record));
        var consultas = consultasMapper.fromEntity(record);
        consultaRepository.save(consultas);

        var dadosMedico = service.buildMedico(record);
        var dadosPaciente = service.buildPaciente(record);
        sentSimpleEmail(dadosPaciente.email(), "Consulta Marcada", "Consulta Marcada com Sucesso");

        return new DadosConsultaDTO(dadosMedico.nome(), dadosMedico.crm(), dadosPaciente.nome(), dadosPaciente.cpf());
    }

    public void sentSimpleEmail(String destinatario, String assunto, String conteudo) {
        JavaMailSender emailSender = MailSend.sendOutlook();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinatario);
        message.setSubject(assunto);
        message.setText(conteudo);
        emailSender.send(message);
    }
}
