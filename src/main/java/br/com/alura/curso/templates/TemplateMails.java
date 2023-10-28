package br.com.alura.curso.templates;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TemplateMails {
    
    @Autowired
    private JavaMailSender mailSender;

    public MimeMessage  sendMailTemplateOne(String destinatario) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);
            
            String MESSAGE_TEMPLATE_CONTENT = "<html lang='en'>"
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
                    +"    <h1 style='color: white'><b>Conta API AULAS Criada</b></h1>"
                    +"    <p style='color: white'>Sua conta API AULAS foi criada com Sucesso. Acesse o aplicativo</p>"
                    +"	<br/>"
                    +"	<img src='cid:googleplay'>"
                    +"	&nbsp;&nbsp;&nbsp;&nbsp;"
                    +"</body>"
                    +"</html>"
                    ;


            compose.setText(MESSAGE_TEMPLATE_CONTENT, true);

            FileSystemResource bannerfirst = new FileSystemResource(new File("/Users/leynnerroque/Documents/Projetos/api/src/main/resources/img/logo-buscavet-v1.png"));

            compose.addInline("googleplay", bannerfirst);


            compose.setTo(destinatario);
            compose.setSubject("Equipe API AULAS");
            compose.setFrom("equipeAPI AULAS@API AULAS.com");
            
            return mimeMessage;
        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
            return null;
        }
    }

    //-----------------------------Envio com HTML Simples Body Content-------------------------------------------
    public MimeMessage sendMailTemplatesTwo(String destinatario){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);

            String MESSAGE_CREATE_COUNT =
                    "    <h1 style='color: #32db64;'><b>Conta API AULAS Criada</b></h1>"
                            + "    <p style='color: #32db64;'>Sua conta API AULAS foi criada com Sucesso. Acesse o aplicativo</p>"
                            + "	<br/>" + "	<img src='C:/execute/banner-google.png'>" + "	&nbsp;&nbsp;&nbsp;&nbsp;"
                            + "	<img style='height: 190px; width: 100px;' src='C:/execute/banner-appstore.png'>";


            mimeMessage.setContent(MESSAGE_CREATE_COUNT, "text/html");

            compose.setTo(destinatario);
            compose.setSubject("Equipe API AULAS");
            compose.setFrom("equipeAPI AULAS@API AULAS.com");

            return mimeMessage;

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
            return null;
        }
    }


    //---------------------------Envio de E-Mail com IMG---------------------------------------------------------
    public MimeMessage sendMailTemplateThree(String destinatario){

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper compose = new MimeMessageHelper(mimeMessage, true);

            String MESSAGE_CONTENT_IMG = "<html><body><img src='cid:banner'></body></html>";

            compose.setText(MESSAGE_CONTENT_IMG, true);

            FileSystemResource bannerfirst = new FileSystemResource(new File("C:/execute/banner-API AULAS.png"));

            compose.addInline("banner", bannerfirst);

            compose.setTo(destinatario);
            compose.setSubject("Equipe API AULAS");
            compose.setFrom("equipeAPI AULAS@API AULAS.com");

            return mimeMessage;

        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
            return null;
        }

    }
}
