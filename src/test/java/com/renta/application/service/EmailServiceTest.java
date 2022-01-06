package com.renta.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    EmailService emailService;

    @BeforeEach
    void setUp(){
    this.emailService=new EmailService();
    }


    @Test
    void sendEmailTest() {
        verify(emailService)
                .sendEmail("Test","test@email.com","just a test to send email");

    }
}