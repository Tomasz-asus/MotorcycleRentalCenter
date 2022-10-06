package com.example.motorcycleDrivingSchool.mail;

import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mails {
    private final List<SimpleMailMessage> simpleMailMessages = new ArrayList<>();
    public void add(SimpleMailMessage simpleMailMessage){
        simpleMailMessages.add(simpleMailMessage);}
    public boolean containsMessageWith(String instructorName){
        return simpleMailMessages
                .stream()
                .anyMatch(simpleMailMessage -> Objects.requireNonNull(simpleMailMessage.getText())
                        .contains("Instructor name: "+ instructorName));
    }
}
