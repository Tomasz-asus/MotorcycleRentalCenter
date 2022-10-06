package com.example.motorcycleDrivingSchool.service;

import com.example.motorcycleDrivingSchool.DTO.InstructorDTO;
import com.example.motorcycleDrivingSchool.DTO.ModelsDTO;
import com.example.motorcycleDrivingSchool.DTO.OfferDTO;
import com.example.motorcycleDrivingSchool.DTO.RentalDTO;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferMailService {

    private final MailSender mailSender;

    public OfferMailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void prepareOffer(OfferDTO offerDTO) {
    }
}
