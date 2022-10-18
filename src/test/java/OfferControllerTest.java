import com.example.MotorcycleRentalCenter.DTO.OfferDTO;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.DTO.InstructorDTO;
import com.example.MotorcycleRentalCenter.DTO.ModelsDTO;
import com.example.MotorcycleRentalCenter.mail.Mails;
import com.example.MotorcycleRentalCenter.models.*;
import com.example.MotorcycleRentalCenter.repository.*;
import com.example.MotorcycleRentalCenter.service.OfferMailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
@Transactional
public class OfferControllerTest {

    @Autowired
    OfferMailService mailService;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProducentRepo producentRepo;
    @Autowired
    ModelsRepo modelsRepo;
    @Autowired
    RentalRepo rentalRepo;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    Mails mails;

    @Test
    public void sendEmail() throws Exception {
        // given
        String instructorName = "Tomi";
        addModels(instructorName);
        RentalDTO rentalDTO = new RentalDTO(LocalDate.of(2022, 10, 25),
                LocalDate.of(2022, 10, 26));

        OfferDTO offerDTO = new OfferDTO("educationsample00@gmail.com",
                List.of(new ModelsDTO("BasicYamaha",
                3,
                6, "Lorem Ipsum",
                "BasicYamaha",
                List.of(new InstructorDTO("Tomi", "bb"),
                        new InstructorDTO("Tomi2", "bbb")),
                List.of(rentalDTO))));
        String jsonString = objectMapper.writeValueAsString(offerDTO);
        // when
        this.mockMvc.perform(post("/offer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)).andExpect(status().isOk());
        // then
        assertThat(mails.containsMessageWith("BasicYamaha")).isTrue();
    }
    private void addModels(String instructorName) {

        Instructor instructor = new Instructor(instructorName, "Lorem Ipsum");
        instructorRepo.save(instructor);
        Rental rental = new Rental(LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 22));
        rentalRepo.save(rental);
        Models basicYamaha = new Models("BasicYamaha", 3.00,  2.0, "Lorem Ipsum", "BasicYamaha",
                List.of(instructor), List.of(rental));
        modelsRepo.save(basicYamaha);
        Producent yamaha = new Producent("Yamaha", List.of(basicYamaha));
        producentRepo.save(yamaha);
        Category category1 = new Category("Sport", "Lorem Ipsum", List.of(yamaha));
        categoryRepo.save(category1);
    }
}
