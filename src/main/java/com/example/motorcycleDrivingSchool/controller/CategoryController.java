package com.example.motorcycleDrivingSchool.controller;

import com.example.motorcycleDrivingSchool.DTO.*;
import com.example.motorcycleDrivingSchool.Exceptions.CategoryNotExist;
import com.example.motorcycleDrivingSchool.Exceptions.NameAlreadyExist;
import com.example.motorcycleDrivingSchool.Exceptions.ProducentNotExist;
import com.example.motorcycleDrivingSchool.service.CategoryService;
import com.example.motorcycleDrivingSchool.service.ModelService;
import com.example.motorcycleDrivingSchool.service.ProducentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final ProducentService producentService;
    private final ModelService modelService;

    public CategoryController(CategoryService categoryService,
                              ProducentService producentService,
                              ModelService modelService) {
        this.categoryService = categoryService;
        this.producentService = producentService;
        this.modelService = modelService;
    }
    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> getCategory(){
        return categoryService.categoryList();
    }
    @PostMapping("/category")
    @ResponseBody
    public CategoryDTO createCategory(
            @RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }
    @GetMapping("category/{categoryName}/producent")
    @ResponseBody
    public List<ProducentDTO> getCategory(@PathVariable String categoryName){
        return categoryService.getProducentDTOS(categoryName);
    }
    @PostMapping("category/{categoryName}/producent")
    public ProducentDTO createCategory(@RequestBody ProducentDTO producentDTO,
                                       @PathVariable String categoryName)
        throws NameAlreadyExist, CategoryNotExist {
        return producentService.addCategory(producentDTO, categoryName);
    }
    @GetMapping("/categor/{categoryName}/producent/{producentName}/models")
    @ResponseBody
    public List<ModelsDTO> getTypeOfSpecificModels(@PathVariable String producentName,
                                                   @PathVariable String categoryName){
        return producentService.getModelsDTOS(producentName, categoryName);
    }
    @PostMapping("/category/{categoryName}/producent/{producentName}/models")
    public ModelsDTO createModels(@RequestBody ModelsDTO modelsDTO,
                                  @PathVariable String producentName)
        throws NameAlreadyExist, ProducentNotExist {
        return modelService.addModels(modelsDTO, producentName);
    }
    @PostMapping("workshops/instructorAssignment")
    public ResponseEntity<Void> addInstructorToModel(@RequestBody InstructorAssignmentDTO instructorAssignmentDTO){
        modelService.addInstructorToModels(instructorAssignmentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("category/periodAssignment/{modelsId}")
    public ResponseEntity<Void> addPeriod(@RequestBody RentalDTO rentalDTO,
                                          @PathVariable String modelsId){
        modelService.addPeriod(rentalDTO, modelsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("category/{categoryName}/producent/{producentName}/models/{modelsId}/assignPeriodAndInstructor")
    public ResponseEntity<Void> assignPeriodAndTInstructorToModels(@RequestBody PeriodAndInstructorAssignDTO periodAndInstructorAssignDTO,
                                                                   @PathVariable String modelsId){
        modelService.addPeriodAndInstructor(periodAndInstructorAssignDTO, modelsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
