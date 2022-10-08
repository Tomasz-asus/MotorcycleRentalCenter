package com.example.MotorcycleRentalCenter.repo;

import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProducentServiceTest {

    @Autowired
    ProducentRepo producentRepo;

    @BeforeEach
    public void delete(){
        producentRepo.deleteAll();
    }

    @Test
    public void addNewProducent(){
    //given
        Producent producent = new Producent("Yamaha", Collections.emptyList());

    //when
        producentRepo.save(producent);

    //then
        List<Producent> list = producentRepo.findAll();
        assertThat(list.size()).isEqualTo(1);
    }

}
