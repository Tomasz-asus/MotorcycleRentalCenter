package com.example.MotorcycleRentalCenter.service;

import com.example.MotorcycleRentalCenter.DTO.*;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfferMailService {


    public OfferMailService(MailSender mailSender) {

        this.mailSender = mailSender;
    }

    private final MailSender mailSender;

    public void prepareOffer(OfferDTO offerDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        System.out.println(offerDTO.getModelsDTOSDTOS()+ "ble");
        simpleMailMessage.setFrom("tomaszgbinance@gmail.pl");//TODO
        simpleMailMessage.setTo(offerDTO.getEmail());
        simpleMailMessage.setSubject(subject());
        simpleMailMessage.setText(message(offerDTO));
        mailSender.send(simpleMailMessage);
    }

    private String subject(){
        return """
                Your offer from MotorcycleRentalShop
                """;
    }

    private String rentalMessage(List<ModelsDTO> models){
        String result = "";
        for (ModelsDTO model : models){
            System.out.println(model + "ble");
            String instructor = "";
            String rentalStart = "";
            String rentalEnd = "";
            for (InstructorDTO instructorDTO : model.getInstructors()){
                instructor += instructorDTO.getName() + " \n";
            }
            for (RentalDTO rentalDTO : model.getRentalDTOS()){
                rentalStart += rentalDTO.getStartRental() + "\n";
                rentalEnd += rentalDTO.getEndRental() + "\n";
            }

            result += """
        Models name: %s
        
        Start Rental: %s
        End Rental: %s
        Instructor name:
        %s
        Price: %s
        
        """.formatted(model.getName(),
                    rentalStart,
                    rentalEnd,
                    instructor,
                    model.getPrice());
        }
        return result;
    }

    private String message(OfferDTO offerDTO){
        String mes = """
                Hello, 
                your choosen models:
                """
                + rentalMessage(offerDTO.getModelsDTOSDTOS()) +
                """
                                        
                        Best regards
                        MotorcycleRentalCenter Team
                        """;
        System.out.println(mes);
        return mes;
    }
}
