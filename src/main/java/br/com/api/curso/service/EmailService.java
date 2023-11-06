package br.com.api.curso.service;

import br.com.api.curso.templates.TemplateMails;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateMails templateMails;

    public void sendMail(String email,String sender,String assunto){
        try{

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email);
            message.setTo(sender);
            message.setSubject(assunto);
            message.setText(assunto);
            mailSender.send(message);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMailTemplate1(String destinatario){
        MimeMessage mimeMessage = templateMails.sendMailTemplateOne(destinatario);
        mailSender.send(mimeMessage);
    }

    public void sendMailTemplate2(String destinatario){
        MimeMessage mimeMessage = templateMails.sendMailTemplatesTwo(destinatario);
        mailSender.send(mimeMessage);
    }

    public void sendMailTemplate3(String destinatario){
        MimeMessage mimeMessage = templateMails.sendMailTemplateThree(destinatario);
        mailSender.send(mimeMessage);
    }
}
