package com.activitiesBackend.activitiesBackend.Services.Email;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class EmailService {

  //  @Autowired
  //  private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

//    public void sendEmail(String from, String to,String subject, String body){
//        SimpleMailMessage message=new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        mailSender.send(message);
//    }
/**
    public String sendMailWithThymleaf(MailModel user) throws MessagingException {
        Context context = new Context();
        context.setVariable("user", user);

        String process = templateEngine.process("welcome.html", context);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Welcome " + user.getTo());
        helper.setText(process, true);
        helper.setTo(user.getTo());
        helper.setFrom("raj**********@gmail.com");
        mailSender.send(mimeMessage);
        return "Sent";
    }

    public String sendMailWithThymleaf(MailModel user) throws MessagingException {
        Context context = new Context();
        context.setVariable("user", user);

        String process = templateEngine.process("welcome.html", context);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Welcome " + user.getTo());
        helper.setText(process, true);
        helper.setTo(user.getTo());
        helper.setFrom("raj**********@gmail.com");
        mailSender.send(mimeMessage);
        return "Sent";
    }
    **/
}
