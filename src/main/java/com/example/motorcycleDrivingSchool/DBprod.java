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

        Category sports = categoryRepo.save(sport);
        categoryRepo.save(adventure);
        categoryRepo.save(chopper);
        categoryRepo.save(city);
/*
        Producent yamaha = new Producent("Yamaha", new ArrayList<>());
        Producent honda = new Producent("Honda", new ArrayList<>());
        Producent suzuki = new Producent("Suzuki", new ArrayList<>());
        Producent kawasaki = new Producent("Kawasaki", new ArrayList<>());

        Producent yamahaProducent = producentRepo.save(yamaha);
        producentRepo.save(honda);
        producentRepo.save(suzuki);
        producentRepo.save(kawasaki);
        producentRepo.findAll()
                .forEach(sports::assignProducent);
        categoryRepo.save(sports);

        Models basic = new Models("Basic", 3800, 150, "description", "frontId");
        Models adV = new Models("advanture", 3800, 150, "description", "frontId");
        Models ci = new Models("city", 3800, 150, "description", "frontId");

        modelsRepo.save(basic);
        modelsRepo.save(adV);
        modelsRepo.save(ci);

        modelsRepo.findAll()
                .forEach(yamahaProducent::assignTypeOfModels);
        producentRepo.save(yamahaProducent);
    }*/
    }
}
