package com.example.MotorcycleRentalCenter.mail;

import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mails {

private final List<SimpleMailMessage> simpleMailMessages = new ArrayList<>();

public void add(SimpleMailMessage simpleMessage) {
        simpleMailMessages.add(simpleMessage);
        }

public boolean containsMessageWith(String modelsName) {
        return simpleMailMessages.stream()
        .anyMatch(simpleMailMessage -> Objects
                .requireNonNull(simpleMailMessage.getText()).contains("Models name: " + modelsName));
        }
        }
