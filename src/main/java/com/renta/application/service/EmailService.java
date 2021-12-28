package com.renta.application.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter
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
            
        }catch (IllegalStateException e){
            throw new IllegalStateException("There was the problem sending an email");
        }

        return "Email was sent successfully to "+toEmail;
    }

}
