package br.com.alura.curso.service;

import br.com.alura.curso.templates.TemplateMails;
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

    public void sendMailTemplate1(){
        MimeMessage mimeMessage = templateMails.sendMailTemplateOne("");
        mailSender.send(mimeMessage);
    }

    public void sendMailTemplate2(){
        MimeMessage mimeMessage = templateMails.sendMailTemplatesTwo("");
        mailSender.send(mimeMessage);
    }

    public void sendMailTemplate3(){
        MimeMessage mimeMessage = templateMails.sendMailTemplateThree("");
        mailSender.send(mimeMessage);
    }
}
