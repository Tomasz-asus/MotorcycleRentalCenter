package com.example.motorcycleDrivingSchool;


import com.example.motorcycleDrivingSchool.models.Category;
import com.example.motorcycleDrivingSchool.models.Models;
import com.example.motorcycleDrivingSchool.models.Producent;
import com.example.motorcycleDrivingSchool.repository.CategoryRepo;
import com.example.motorcycleDrivingSchool.repository.ModelsRepo;
import com.example.motorcycleDrivingSchool.repository.ProducentRepo;
import com.example.motorcycleDrivingSchool.service.CategoryService;
import com.example.motorcycleDrivingSchool.service.ModelService;
import com.example.motorcycleDrivingSchool.service.ProducentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class CategoryControllerTest {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProducentService producentService;
    @Autowired
    ModelService modelService;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProducentRepo producentRepo;
    @Autowired
    ModelsRepo modelsRepo;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        categoryRepo.deleteAll();
    }

    @Test
    public void shouldShowCategoryList() throws Exception {
        //given
        addModels();
        //then
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/category"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String contentAsString = mvcResult
                .getResponse()
                .getContentAsString();

        List<Category> categoryList = objectMapper
                .readValue(contentAsString,
                new TypeReference<>() {
                });
        assertThat(categoryList.size()).isEqualTo(1);
    }
    private void addModels() {
        Category category = new Category("SPORT","descriptionSportTest","imgUrlSportTest");
        categoryRepo.save(category);
        Producent producent = new Producent("Yamaha", new ArrayList<>());
        producentRepo.save(producent);
        Models models = new Models("Basic","durationModelsTest",38000d,"descriptionModelTest","frontIdModelsTest",new ArrayList<>(),new ArrayList<>());
        modelsRepo.save(models);
    }
}
