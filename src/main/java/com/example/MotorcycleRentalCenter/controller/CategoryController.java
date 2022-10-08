package com.example.MotorcycleRentalCenter.controller;

import com.example.MotorcycleRentalCenter.DTO.*;
import com.example.MotorcycleRentalCenter.Exceptions.CategoryNotExist;
import com.example.MotorcycleRentalCenter.Exceptions.NameAlreadyExist;
import com.example.MotorcycleRentalCenter.Exceptions.ProducentNotExist;
import com.example.MotorcycleRentalCenter.service.CategoryService;
import com.example.MotorcycleRentalCenter.service.ModelService;
import com.example.MotorcycleRentalCenter.service.ProducentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class CategoryController {
    private final CategoryService categoryService;

    private final ProducentService producentService;

    private final ModelService modelService;
    public CategoryController(
            CategoryService categoryService,
            ProducentService producentService,
            ModelService modelService) {
        this.categoryService = categoryService;
        this.producentService = producentService;
        this.modelService = modelService;
    }

    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> getWorkShops(){

        return categoryService.categoryList();
    }

    @PostMapping("/category")
    @ResponseBody
    public CategoryDTO createWorkshop(@RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping("category/{categoryName}/producent")
    @ResponseBody
    public List<ProducentDTO> getWorkshopsSubCat(@PathVariable String categoryName) {
        return categoryService.getProducentDTOS(categoryName);
    }

    @PostMapping("/category/{categoryName}/producent")
    public ProducentDTO createSubWorkshops(@RequestBody ProducentDTO producentDTO,
                                        @PathVariable String categoryName)
            throws NameAlreadyExist, CategoryNotExist {
        return producentService.addCategoryProducent(producentDTO, categoryName);
    }

    @GetMapping("/category/{categoryName}/producent/{producentName}/models")
    @ResponseBody
    public List<ModelsDTO> getModels(
            @PathVariable String producentName, @PathVariable String categoryName){
        return producentService.getModelsDTOS(producentName, categoryName);
    }

    @PostMapping("/category/{categoryName}/producent/{producentName}/models")
    public ModelsDTO createModels(@RequestBody ModelsDTO modelsDTO,
                                                  @PathVariable String producentName)
            throws NameAlreadyExist, ProducentNotExist {
        return modelService.addModels(modelsDTO, producentName);
    }
    @PostMapping("category/instructorAssignment")
    public ResponseEntity<Void> addInstructorToModels(@RequestBody InstructorAssignmentDTO instructorAssignmentDTO) {
        modelService.addInstructorToModels(instructorAssignmentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("category/modelsRentalAssignment/{modelsId}")
    public ResponseEntity<Void> addModelsRental(@RequestBody RentalDTO rentalDTO,
                                                  @PathVariable String modelsId){
        modelService.addModelsPeriod(rentalDTO, modelsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("category/{categoryName}/producent/{producentName}/models/{modelsId}/assignRentalAndInstructor")
    public ResponseEntity<Void> assignRentalAndInstructorToModels(@RequestBody RentalAndInstructorAssignDTO rentalAndInstructorAssignDTO,
                                                                 @PathVariable String modelsId){
        modelService.addRentialAndInstructor(rentalAndInstructorAssignDTO, modelsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
