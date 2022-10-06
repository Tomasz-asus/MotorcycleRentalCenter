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
    ModelsRepo modelsRepo;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProducentService producentService;
    @Autowired
    ModelService modelService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    OfferMailService offerMailService;
    @Autowired
    RentalRepo rentalRepo;

    @Override
    public void run(String... args){
        Category sport = new Category("Sport","description Sport","Sport imgUrl");
        Category adventure = new Category("Adventure","description Adventure","Adventure imgUrl");
        Category chopper = new Category("Chopper","description Chopper","Chopper imgUrl");
        Category city = new Category("City","description City","City imgUrl");

        Category sports = categoryRepo.save(sport);
        Category adventures = categoryRepo.save(adventure);
        Category choppers = categoryRepo.save(chopper);
        Category cites = categoryRepo.save(city);

        Producent yamaha = new Producent("Yamaha",new ArrayList<>());
        Producent honda = new Producent("Honda", new ArrayList<>());
        Producent suzuki = new Producent("Suzuki", new ArrayList<>());
        Producent kawasaki = new Producent("Kawasaki", new ArrayList<>());

        Producent yamahaProducent = producentRepo.save(yamaha);
        Producent hondaProducent = producentRepo.save(honda);
        Producent suzukiProducent = producentRepo.save(suzuki);
        Producent kawasakiProducent = producentRepo.save(kawasaki);

        producentRepo.findAll()
                .forEach(sports::assignProducent);
        categoryRepo.save(sports);

        RentalDTO rentalDTO = new RentalDTO(LocalDate.of(2022,10,10));
                LocalDate.of(2022,10,12);

        OfferDTO offerDTO = new OfferDTO("biuro@forplastics.pl",
                List.of(new ModelsDTO("Basic",
                        "durationBasic",
                        1000,
                        "descriptionBasic",
                        "frontIdBasic",
                        List.of(),
                        List.of())));

                offerMailService.prepareOffer(offerDTO);
    }
}
