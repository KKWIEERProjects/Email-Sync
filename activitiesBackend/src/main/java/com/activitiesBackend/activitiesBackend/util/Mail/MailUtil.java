package com.activitiesBackend.activitiesBackend.util.Mail;

import com.activitiesBackend.activitiesBackend.exceptions.EmailAddressException;
import com.activitiesBackend.activitiesBackend.exceptions.EmailAlreadyExists;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.angus.mail.smtp.SMTPAddressFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Properties;

@Component
public class MailUtil {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public String createTemplate(Context context, String templateName){
        System.out.println("here");
        return templateEngine.process(templateName, context);
    }

    public void sendMail(HttpServletResponse response, String template,
                         HashMap<String ,String> info){
        //String subject,String ourToken,String ourEmail,String email


        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587"); // Port for STARTTLS


        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(info.get("ourEmail"),info.get("ourToken"));
            }
        });

        MimeMessage message  = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(info.get("ourEmail")));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(info.get("email")));

            message.setSubject(info.get("subject"));


            message.setText(template,null,"html");



            Transport.send(message);
        }catch(SMTPAddressFailedException ex){

            System.out.println(ex);
            throw new EmailAddressException("Email not found");
        }
        catch(Exception ex){
            System.out.println(ex);
            throw new EmailAddressException("Error occured");
        }

    }
}
