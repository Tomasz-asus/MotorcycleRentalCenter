package com.example.motorcycleDrivingSchool;

import com.example.motorcycleDrivingSchool.DTO.InstructorDTO;
import com.example.motorcycleDrivingSchool.DTO.ModelsDTO;
import com.example.motorcycleDrivingSchool.DTO.OfferDTO;
import com.example.motorcycleDrivingSchool.DTO.RentalDTO;
import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Models;
import com.example.motorcycleDrivingSchool.models.Producent;
import com.example.motorcycleDrivingSchool.repository.*;
import com.example.motorcycleDrivingSchool.service.*;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("prod")
public class DBprod implements CommandLineRunner {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProducentRepo producentRepo;
    @Autowired
    OfferMailService offerMailService;
    @Autowired
    ModelsRepo modelsRepo;

    @Override
    public void run(String... args) {
        Category sport = new Category("Sport", "description Sport", "Sport imgUrl");
        Category adventure = new Category("Adventure", "description Adventure", "Adventure imgUrl");
        Category chopper = new Category("Chopper", "description Chopper", "Chopper imgUrl");
        Category city = new Category("City", "description City", "City imgUrl");

        Category sportCategory = categoryRepo.save(sport);
        categoryRepo.save(adventure);
        categoryRepo.save(chopper);
        categoryRepo.save(city);
    }
}

