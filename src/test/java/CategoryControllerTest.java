import com.example.MotorcycleRentalCenter.DTO.RentalAndInstructorAssignDTO;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.DTO.InstructorDTO;
import com.example.MotorcycleRentalCenter.DTO.ModelsDTO;
import com.example.MotorcycleRentalCenter.models.Producent;
import com.example.MotorcycleRentalCenter.models.Instructor;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.models.Category;
import com.example.MotorcycleRentalCenter.repository.ProducentRepo;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
import com.example.MotorcycleRentalCenter.repository.ModelsRepo;
import com.example.MotorcycleRentalCenter.repository.CategoryRepo;
import com.example.MotorcycleRentalCenter.service.CategoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class CategoryControllerTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    InstructorRepo instructorRepo;
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
                .andDo(MockMvcResultHandlers.print()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Category> categoryList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        assertThat(categoryList.size()).isEqualTo(1);
    }

    @Test
    public void addInstructor() throws Exception {
        // given
        InstructorDTO instructorDTO = new InstructorDTO("Tomi", "Yamaha master");
        String jsonString = objectMapper.writeValueAsString(instructorDTO);
        // when
        this.mockMvc.perform(post("/instructors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());
        // then
        assertThat(instructorRepo.findByName("Tomi")).isNotNull();
    }

    @Test
    public void showInstructor() throws Exception {
        // given
        Instructor instructor = new Instructor("Tomi", "Yamaha Master");
        instructorRepo.save(instructor);
        // when
        String contentAsString = mockMvc.perform(get("/instructors"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InstructorDTO> instructorDTO = Arrays.asList(objectMapper.readValue(contentAsString, InstructorDTO[].class));
        // then
        assertThat(instructorDTO
                .get(0)
                .getName())
                .isEqualTo("Tomi");
    }
    @Test
    public void showModels() throws Exception{
        // given
        Category category1 = new Category("Sport", "blebleble", new ArrayList<>());
        categoryRepo.save(category1);
        // and
        Producent yamaha = new Producent("Yamaha", new ArrayList<>());
        producentRepo.save(yamaha);
        producentRepo.findAll().forEach(category1::asssignProducent);
        // and
        Models basicYamaha = new Models("BasicYamaha", 3.00,  2.0, "Lorem Ipsum", "BasicYamaha");
        modelsRepo.save(basicYamaha);
        modelsRepo.findAll()
                .forEach(yamaha::assignModels);
        // when
        String contentAsString = mockMvc.perform(get("/category/Sport/producnet/Yamaha/models"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<ModelsDTO> modelsDTOS = Arrays.asList(objectMapper.readValue(contentAsString, ModelsDTO[].class));
        // then
        assertThat(modelsDTOS.get(0).getName()).isEqualTo("BasicYamaha");
    }

    @Test
    public void assignRentalToModels() throws Exception {
        // given
        addModels();
        // and
        RentalDTO rentalDTO = new RentalDTO(LocalDate.of(2022, 9, 23),
                LocalDate.of(2022, 9, 24));
        String jsonString = objectMapper.writeValueAsString(rentalDTO);
        // when
        this.mockMvc.perform(post("/category/modelsRentaldAssignment/YamahaBasic")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());
            
        // then
        Optional<Models> yamahaBasic = modelsRepo.findByFrontId("YamahaBasic");
        assertThat(yamahaBasic.map(m -> m.getRental().size()).get()).isEqualTo(1);
    }

    @Test
    public void assignRentalAndInstructorToModel() throws Exception {
        // given
        addModels();
        RentalAndInstructorAssignDTO rentalAndInstructorAssignDTO = new RentalAndInstructorAssignDTO(
                new RentalDTO(LocalDate.of(2022, 10, 23), LocalDate.of(2022, 10, 24)),
                new InstructorDTO("Tomi", "master"));
        String jsonString = objectMapper.writeValueAsString(rentalAndInstructorAssignDTO);
        // when
        this.mockMvc.perform(post("/category/sport/producent/Yamaha/models/YamahaBasic/assignRentalAndInstructor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());
        // then
        Optional<Instructor> instructor = instructorRepo.findByName("Tomi");
        assertThat(instructor.map(m -> m.getUnavailableDays().size()).get()).isEqualTo(2);
    }

    private void addModels() {
        Category sport = new Category("Sport", "blebleble", Collections.emptyList());
        categoryRepo.save(sport);
        Producent yamaha = new Producent("Yamaha", new ArrayList<>());
        producentRepo.save(yamaha);
        Models basicYamaha = new Models("BasicYamaha", 3.00,  2.0, "Lorem Ipsum", "BasicYamaha");
        modelsRepo.save(basicYamaha);
    }
}
