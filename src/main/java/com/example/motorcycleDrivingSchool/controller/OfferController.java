package com.example.motorcycleDrivingSchool.controller;

import com.example.motorcycleDrivingSchool.DTO.OfferDTO;
import com.example.motorcycleDrivingSchool.service.OfferMailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/offer")
public class OfferController {
    private final OfferMailService offerMailService;

    public OfferController(OfferMailService offerMailService) {
        this.offerMailService = offerMailService;
    }

    @PostMapping
    ResponseEntity<Void>sendOffer(@RequestBody OfferDTO offerDTO){
        offerMailService.prepareOffer(offerDTO);
        return new ResponseEntity<>(OK);
    }
}
