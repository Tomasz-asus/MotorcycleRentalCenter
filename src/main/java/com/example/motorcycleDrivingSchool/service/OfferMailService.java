package com.example.motorcycleDrivingSchool.service;

import com.example.motorcycleDrivingSchool.DTO.*;
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
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("cc@gmail.com");//TODO
        simpleMailMessage.setTo(offerDTO.getEmail());
        simpleMailMessage.setSubject(subject());
        simpleMailMessage.setText(message(offerDTO));
        mailSender.send(simpleMailMessage);
    }
    private String subject(){
        return """
                Your offer from MotorcyckleShop - % rental
                """;
    }
    private String rentalMessage(List<ModelsDTO> models){
        String result = "";
        for(ModelsDTO model : models ){
            String mod = "";
            String rentalStart = "";
            String rentalEnd = "";
            for (InstructorDTO instructorDTO :model.getInstructor()){
                mod += instructorDTO.getName() + "\n";
            }
            for (RentalDTO rentalDTO : model.getRentalDTO()){
                rentalStart += rentalDTO.getStartRental() + "\n";
                rentalEnd += rentalDTO.getEndRental() + "\n";
            }
            result += """
                    Rental name: %s
                    
                    Start: %s
                    End: %s
                    Instructor name: %s
                    Price: %s
                    
                    """.formatted(model.getName(),
                    rentalStart,
                    rentalEnd,
                    mod,
                    model.getPrice());
        }
        return result;
    }
    private String message(OfferDTO offerDTO){
        String mes = """
                Hello,
                your choosen rental:
                """
                +rentalMessage(offerDTO.getModelsDTOS()) +
                """
                        Best regards
                        MotorcycleShop
                        """;
        System.out.println(mes);
        return mes;
    }
}
