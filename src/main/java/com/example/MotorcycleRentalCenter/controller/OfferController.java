package com.example.MotorcycleRentalCenter.controller;

import com.example.MotorcycleRentalCenter.DTO.OfferDTO;
import com.example.MotorcycleRentalCenter.service.OfferMailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/offer")
class OfferController {

    private final OfferMailService offerMailService;

    OfferController(OfferMailService offerMailService) {
        this.offerMailService = offerMailService;
    }

    @PostMapping
    ResponseEntity<Void> sendOffer(@RequestBody OfferDTO offerDTO){
        offerMailService.prepareOffer(offerDTO);
        return new ResponseEntity<>(OK);
    }
}
