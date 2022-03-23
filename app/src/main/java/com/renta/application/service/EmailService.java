package com.renta.application.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String subject,String toEmail,String body){
        try{
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setFrom("devteamrenta@gmail.com");
            simpleMailMessage.setTo(toEmail);
            simpleMailMessage.setText(body);
            javaMailSender.send(simpleMailMessage);

//            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
//
//            mimeMessageHelper.setSubject(subject);
//            mimeMessageHelper.setFrom("devteamrenta@gmail.com");
//            mimeMessageHelper.setTo(toEmail);
//            mimeMessageHelper.setText(body);
//            javaMailSender.send(mimeMessage);
            
        }catch (IllegalStateException e){
            throw new IllegalStateException("There was the problem sending an email");
        }
//        catch (MessagingException e) {
//            e.printStackTrace();
//        }

        return "Email was sent successfully to "+toEmail;
    }

}
