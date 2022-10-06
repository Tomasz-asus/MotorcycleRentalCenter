package com.example.motorcycleDrivingSchool.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {
    @Bean
    @Profile("prod")
    public MailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("cc@gmail.com");//TODO
        mailSender.setPassword("kkkk");//TODO

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
    @Bean
    @Profile("!prod")
    public MailSender dummyMailSender (Mails mails){
        return new DummyMailSender(mails);
    }
    @Bean
    @Profile("!prod")
    public Mails mails(){
        return new Mails();
    }
    @Bean
    @Profile("!prod")
    public SimpleMailMessage simpleMailMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Message");
        return message;
    }
}
