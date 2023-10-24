package br.com.alura.curso.configs;

import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

public class TemplateMessageMail {

    public static void sendEmailTemplateBuscavet(String destinatario) {
        try {
            JavaMailSender emailSender = MailSend.sendGmail();

            MimeMessage mimeMessage = emailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);


            String MESSAGE_CREATE_COUNT_SUCCESS = "<html lang='en'>"
                    +"<head>"
                    +"    <meta charset='utf-8'>"
                    +"    <meta name='viewport' content='width=device-width, initial-scale=1'>"
                    +"    <link rel=''shortcut icon' href='favicon.ico' />"
                    +"</head>"
                    +"<body style='background-color: #32db64;'>"
                    +"		 <style>"
                    +"        * {"
                    +"            line-height: 1.2;"
                    +"            margin: 0;"
                    +"        }"
                    +"html {"
                    +"            color: #888;"
                    +"            display: table;"
                    +"            font-family: sans-serif;"
                    +"            height: 100%;"
                    +"            text-align: center;"
                    +"            width: 100%;"
                    +"        }"
                    +"body {"
                    +"            display: table-cell;"
                    +"            vertical-align: middle;"
                    +"            margin: 2em auto;"
                    +"        }"

                    +"        h1 {"
                    +"            color: #555;"
                    +"            font-size: 2em;"
                    +"            font-weight: 400;"
                    +"        }"

                    +"        p {"
                    +"            margin: 0 auto;"
                    +"            width: 280px;"
                    +"        }"
                    +"@media only screen and (max-width: 280px) {"

                    +"            body, p {"
                    +"                width: 95%;"
                    +"            }"

                    +"            h1 {"
                    +"                font-size: 1.5em;"
                    +"                margin: 0 0 0.3em;"
                    +"            }"

                    +"        }"
                    +"    </style>"
                    +"    <h1 style='color: white'><b>Conta Buscavet Criada</b></h1>"
                    +"    <p style='color: white'>Sua conta Buscavet foi criada com Sucesso. Acesse o aplicativo</p>"
                    +"	<br/>"
                    +"	<img src='cid:googleplay'>"
                    +"	&nbsp;&nbsp;&nbsp;&nbsp;"
                    +"	<img src='cid:appstore'>"
                    +"</body>"
                    +"</html>"
                    ;


            compose.setText(MESSAGE_CREATE_COUNT_SUCCESS, true);

            FileSystemResource bannerfirst = new FileSystemResource(new File("C:/opt/buscavet/resources/banner-google.png"));
            FileSystemResource bannersecond = new FileSystemResource(new File("C:/opt/buscavet/resources/banner-appstore.png"));

           // compose.addInline("googleplay", bannerfirst);
           // compose.addInline("appstore", bannersecond);


            compose.setTo(destinatario);
            compose.setSubject("Equipe Buscavet");
            compose.setFrom("leynner.lima@farmaciassaojoao.com.br");


            emailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }

    }

    //-----------------------------Envio com HTML Simples Body Content-------------------------------------------
    public static void sendMailSimpleTemplates(String destinatario){
        try {
            JavaMailSender emailSender = MailSend.sendGmail();

            MimeMessage mimeMessage = emailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);

            String MESSAGE_CREATE_COUNT =
                    "    <h1 style='color: #32db64;'><b>Conta Buscavet Criada</b></h1>"
                            + "    <p style='color: #32db64;'>Sua conta Buscavet foi criada com Sucesso. Acesse o aplicativo</p>"
                            + "	<br/>" + "	<img src='C:/execute/banner-google.png'>" + "	&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "	<img style='height: 190px; width: 100px;' src='C:/execute/banner-appstore.png'>";


            mimeMessage.setContent(MESSAGE_CREATE_COUNT, "text/html");

            compose.setTo(destinatario);
            compose.setSubject("Equipe Buscavet");
            compose.setFrom("equipebuscavet@buscavet.com");

            emailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }


    //---------------------------Envio de E-Mail com IMG---------------------------------------------------------
    public static void sendMailContentImageTemplate(String destinatario){

        try {
            JavaMailSender emailSender = MailSend.sendGmail();

            MimeMessage mimeMessage = emailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);

            String MESSAGE_CONTENT_IMG = "<html><body><img src='cid:banner'></body></html>";

            compose.setText(MESSAGE_CONTENT_IMG, true);

            FileSystemResource bannerfirst = new FileSystemResource(new File("C:/execute/banner-buscavet.png"));

            compose.addInline("banner", bannerfirst);

            compose.setTo(destinatario);
            compose.setSubject("Equipe Buscavet");
            compose.setFrom("equipebuscavet@buscavet.com");

            emailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }

    }
}
