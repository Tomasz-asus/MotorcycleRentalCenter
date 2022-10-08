package com.example.MotorcycleRentalCenter.repo;

import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
import com.example.MotorcycleRentalCenter.repository.InstructorUnavailableDaysRepo;
import com.example.MotorcycleRentalCenter.repository.ModelsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class ModelsRepoTest {

    @Autowired
    ModelsRepo modelsRepo;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    InstructorUnavailableDaysRepo instructorUnavailableDaysRepo;
    @Autowired
    ProducentRepo producentRepo;

    @Test
    public void addNewModels(){
        //given
        Models basicYamaha = getModels();

        //when
        modelsRepo.save(basicYamaha);

        //then
        List<Models> list1 = modelsRepo.findAll();
        assertThat(list1.size()).isEqualTo(1);
    }

    @Test
    public void addNewModelsToProducent(){
        //given
        Producent producent = new Producent("Yamaha", Collections.emptyList());
        Producent producentJava = producentRepo.save(producent);
        Models basicYamaha = getModels();
        modelsRepo.save(basicYamaha);
        List<Models> models = modelsRepo.findAll();

        //when
        producentJava.setModels(models);

        //then
        assertThat(basicYamaha.equals(producentJava.getModels()));
    }

    private Models getModels() {
        return new Models("BasicYamaha", 30.00,  3.0, "Lorem Ipsum", "BasicYamaha");
    }
}
