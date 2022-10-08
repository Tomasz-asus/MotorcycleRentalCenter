package com.example.MotorcycleRentalCenter;

import com.example.MotorcycleRentalCenter.DTO.InstructorDTO;
import com.example.MotorcycleRentalCenter.DTO.ModelsDTO;
import com.example.MotorcycleRentalCenter.DTO.OfferDTO;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.models.Category;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.repository.*;
import com.example.MotorcycleRentalCenter.service.*;
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
    CategoryService categoryService;
    @Autowired
    ProducentService producentService;
    @Autowired
    OfferMailService offerMailService;

    @Override
    public void run(String... args) {

        Category sport = new Category("SPORT", "Lorem Ipsum", "", new ArrayList<>());
        Category adventure = new Category("ADVENTURE", "Lorem Ipsum", "", new ArrayList<>());
        Category chopper = new Category("CHOPPER", "Lorem Ipsum", "", new ArrayList<>());
        Category city = new Category("CITY", "Lorem Ipsum", "", new ArrayList<>());

        Category sportCategory = categoryRepo.save(sport);
        categoryRepo.save(adventure);
        categoryRepo.save(chopper);
        categoryRepo.save(city);

        Producent yamaha = new Producent("Yamaha", new ArrayList<>());
        Producent honda = new Producent("Honda", new ArrayList<>());
        Producent suzuki = new Producent("Suzuki", new ArrayList<>());
        Producent kawasaki = new Producent("Kawasaki", new ArrayList<>());

        Producent yamahaProducent = producentRepo.save(yamaha);
        producentRepo.save(honda);
        producentRepo.save(suzuki);
        producentRepo.save(kawasaki);
        producentRepo.findAll()
                .forEach(sportCategory::asssignProducent);
        categoryRepo.save(sportCategory);

        Models basicYamaha = new Models("BasicYamaha", 0.00,  1.0, "Lorem Ipsum", "BasicYamaha");
        Models advanceYamaha = new Models("AdvanceYamaha", 0.00,  2.0, "Lorem Ipsum", "AdvanceYamaha");
        Models cityYamaha = new Models("CityYamaha", 0.00,  3.0, "Lorem Ipsum", "CityYamaha");

        modelsRepo.save(basicYamaha);
        modelsRepo.save(advanceYamaha);
        modelsRepo.save(cityYamaha);

        modelsRepo.findAll()
                .forEach(yamahaProducent::assignModels);
        producentRepo.save(yamahaProducent);

        RentalDTO rentalDTO = new RentalDTO(
                LocalDate.of(2022,10,10),
                LocalDate.of(2022,10,20));

        OfferDTO offerDTO = new OfferDTO("cc@qmail.com", //TODO create email
                List.of(new ModelsDTO("BasicYamaha",
                        1.00,
                        2.00,
                        "Lorem Ipsum",
                        "BasicYamaha",
                        List.of(new InstructorDTO("Tomi",
                                "bbbb"), new InstructorDTO("Tomi2",
                                "bbb2")),
                        List.of(rentalDTO))));

        offerMailService.prepareOffer(offerDTO);

    }
}
