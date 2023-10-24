package br.com.alura.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

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
}
