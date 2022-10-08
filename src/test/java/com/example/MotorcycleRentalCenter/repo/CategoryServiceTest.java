package com.example.MotorcycleRentalCenter.repo;

import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.models.Category;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import com.example.MotorcycleRentalCenter.repository.CategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class CategoryServiceTest {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProducentRepo producentRepo;

    @BeforeEach
    public void setup(){
        categoryRepo.deleteAll();
    }

    @Test
    public void addNewCategory(){
        //given
        Producent producent = new Producent("Yamaha", Collections.emptyList());
        producentRepo.save(producent);
        List<Producent> list = producentRepo.findAll();
        Category category = new Category("Sport", "blebleble", "image", list);

        //when
        categoryRepo.save(category);

        //then
        List<Category> list1 = categoryRepo.findAll();
        assertThat(list1.size()).isEqualTo(1);
    }

    @Test
    public void showAllCategory(){
        //given
        Category category1 = new Category( "Sport", "blebleble", new ArrayList<>());

        //when
        Category save1 = categoryRepo.save(category1);
        save1.asssignProducent(new Producent("Yamaha", new ArrayList<>()));

        //then
        assertThat(save1.getShopsCategories().get(0)).isEqualTo(new Producent("Yamaha", new ArrayList<>()));
    }

    @Test
    public void showSpecificWorkshopByName(){
        //given
        Category category1 = new Category("Adventure", "blebleble", new ArrayList<>());
        Category category2 = new Category("Sport", "blebleble2", new ArrayList<>());

        //when
        categoryRepo.save(category1);
        categoryRepo.save(category2);
        Optional<Category> category = categoryRepo.findByName("Adventure");

        //then
        assertThat(category.get()).isEqualTo(category1);
    }

    @Test
    public void findByImageName(){
        //given
        Category category1 = new Category("Adventure", "blebleble", "image1", new ArrayList<>());
        Category category2 = new Category("Yamaha", "blebleble2", "image2", new ArrayList<>());

        //when
        categoryRepo.save(category1);
        categoryRepo.save(category2);

        //then
        Optional<Category> category = categoryRepo.findByImgUrl("image1");
        assertThat(category.get()).isEqualTo(category1);

    }
    @Test
    public void addProducentToCategory(){
        //given
        Category category2 = new Category("Sport", "blebleble2", "image2", new ArrayList<>());
        Producent producent = new Producent("Yamaha", new ArrayList<>());
         //when
        categoryRepo.save(category2);
        producentRepo.save(producent);
        producentRepo.findAll().forEach(category2::asssignProducent);
        //then
        Optional<Category> category = categoryRepo.findByName("Sport");
        assertThat(category.get()).isEqualTo(category2);

    }
}
