import com.example.MotorcycleRentalCenter.DTO.InstructorAssignmentDTO;
import com.example.MotorcycleRentalCenter.DTO.RentalDTO;
import com.example.MotorcycleRentalCenter.models.Instructor;
import com.example.MotorcycleRentalCenter.models.Models;
import com.example.MotorcycleRentalCenter.repository.InstructorRepo;
import com.example.MotorcycleRentalCenter.repository.ModelsRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = InstructorControllerTest.class)
@AutoConfigureMockMvc
@Transactional

public class InstructorControllerTest {

    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    ModelsRepo modelsRepo;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void assignInstructorToModels() throws Exception {
        // given
        String instructorName = "Tomi";
        aInstructorWithName(instructorName);
        // and
        String modelsName = "City";
        aModelsWithName(modelsName);
        // and
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO(instructorName, modelsName);
        String jsonString = objectMapper.writeValueAsString(instructorAssignmentDTO);

        // when
        this.mockMvc.perform(post("/category/instructorAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isOk());

        // then
        assertThat(instructorsAssignedToModels(modelsName))
                .containsExactlyInAnyOrder("Tomi");
    }

    @Test
    public void InstructorIsNotExist() throws Exception {
        // given
        String modelsName = "City";
        aModelsWithName(modelsName);
        // and
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO("Tomi", modelsName);
        String jsonString = objectMapper.writeValueAsString(instructorAssignmentDTO);
        // expect
        this.mockMvc.perform(post("/category/instructorAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isNotFound());
    }

    @Test
    public void ModelsNotExist() throws Exception {
        // given
        String instructorName = "Tomi";
        aInstructorWithName(instructorName);
        // and
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO(instructorName, "Ba");
        String jsonString = objectMapper.writeValueAsString(instructorAssignmentDTO);
        // expect
        this.mockMvc.perform(post("/category/instructorAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isNotFound());
    }
    @Test
    public void instructorIsAssigned() throws Exception {
        // given
        String instructorName = "Tomi";
        aInstructorWithName(instructorName);
        // and
        String modelsName = "City";
        aModelsWithName(modelsName);
        // and
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO(instructorName, modelsName);
        String jsonString = objectMapper.writeValueAsString(instructorAssignmentDTO);
        // and
        this.mockMvc.perform(post("/category/instructorAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString));
        // when
        this.mockMvc.perform(post("/category/instructorAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isBadRequest());
        // then
        assertThat(instructorsAssignedToModels(modelsName))
                .containsExactlyInAnyOrder("Tomi");
    }

    @Test
    public void assignUnavailableDays() throws Exception {
        // given
        String instructorName = "Tomi";
        aInstructorWithName(instructorName);

        // and
        RentalDTO rentalDTO = new RentalDTO(LocalDate.of(2022, 10, 23),
                LocalDate.of(2022, 10, 24));
        String jsonString = objectMapper.writeValueAsString(rentalDTO);

        // when
        this.mockMvc.perform(post("/instuctor/unavailableDaysAssign/Andrzej")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());

        // then
        Optional<Instructor> instructor = instructorRepo.findByName("Tomi");
        assertThat(instructor.map(m -> m.getUnavailableDays().size()).get()).isEqualTo(2);

    }

    private void aModelsWithName(String modelsName) {
        Models models = new Models(modelsName, 3.00,  2.0, "Lorem Ipsum", "BasicYamaha");
        modelsRepo.save(models);
    }
    private void aInstructorWithName(String instructorName) {
        Instructor instructor = new Instructor(instructorName, "Lorem Ipsum");
        instructorRepo.save(instructor);
    }

    private List<String> instructorsAssignedToModels(String modelsName) {
        return modelsRepo.findByName(modelsName).stream()
                .flatMap(t -> t.getInstructor()
                        .stream()
                        .map(Instructor::getName))
                .toList();
    }

}
