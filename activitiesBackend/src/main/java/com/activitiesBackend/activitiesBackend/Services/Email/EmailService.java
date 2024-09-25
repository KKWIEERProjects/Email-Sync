package com.activitiesBackend.activitiesBackend.Services.Email;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//    @Autowired
//    private JavaMailSender mailSender;

    @Value("${email}")
    private String sendEmail;

    public void sendEmail(String email,String subject,String content) throws Exception {
        //try{
           // JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

//            MimeMessage message=mailSender.createMimeMessage();
//            MimeMessageHelper helper=new MimeMessageHelper(message);
//
//            helper.setFrom(sendEmail);
//            helper.setTo(email);
//
//            helper.setSubject(subject);
//            helper.setText(content,true);
//
//            mailSender.send(message);
//
//            mailSender=null;
//
//        }catch (Exception ex){
//            throw new Exception(ex.toString());
//        }

    }


}
