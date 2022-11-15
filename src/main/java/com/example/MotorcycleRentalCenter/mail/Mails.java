package com.example.MotorcycleRentalCenter.mail;

import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.List;

public class Mails {

private final List<SimpleMailMessage> simpleMailMessages = new ArrayList<>();

public void add(SimpleMailMessage simpleMessage) {
        simpleMailMessages.add(simpleMessage);
        }

        }
