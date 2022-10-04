package com.example.motorcycleDrivingSchool.service;

/*
@Service
@Transactional
public class ModelService {

    private final Mapper mapper;

    private final ProducentRepo producentRepo;

    private final ModelsRepo modelsRepo;

    private final CategoryRepo categoryRepo;

    private final InstructorRepo instructorRepo;

    private final InstructorService instructorService;


    public ModelService(Mapper mapper,
                        ProducentRepo producentRepo,
                        ModelsRepo modelsRepo,
                        CategoryRepo categoryRepo,
                        InstructorRepo instructorRepo,
                        InstructorService instructorService) {
        this.mapper = mapper;
        this.producentRepo = producentRepo;
        this.modelsRepo = modelsRepo;
        this.categoryRepo = categoryRepo;
        this.instructorRepo = instructorRepo;
        this.instructorService = instructorService;
    }

public ModelsDTO addModels(ModelsDTO modelsDTO, String producentName){
    Producent producent=producentRepo.findByName(producentName)
            .orElseThrow(ProducentNotExist::new);

    isNameOfModelsExist(modelsDTO, producent);
        modelsDTO.assignFrontId(modelsDTO.getName(), producentName);
        Models models = mapper.modelsDTOToModels(modelsDTO);
        Models saveToRepo = modelsRepo.save(models);
        Producent.assignModels(saveToRepo);
        ProducentRepo.save(producent);

        return mapper.modelsToDTO(saveToRepo);

    }

    public void addInstructorToModels(InstructorAssignmentDTO instructorAssignmentDTO){

        Instructor instructor = (Instructor) instructorRepo.findByName(instructorAssignmentDTO.getInstructorName())
                .orElseThrow(InstructorIsNotExist::new);
        Models models = (Models) modelsRepo.findByFrontId(instructorAssignmentDTO.getInstructorId())
                .orElseThrow(ModelsNotExist::new);

        isInstructorAssigned(instructorAssignmentDTO, models);
        assignInstructor(instructor, models);
        modelsRepo.save(models);
    }

    private void assignInstructor(Instructor instructor, Models models) {
        models.assignInstructor(instructor);
    }

    private void isNameOfModelsExist(ModelsDTO modelsDTO, Producent producent) {
        if (producent.getModels().stream()
                .anyMatch(subcat -> subcat.getName()
                        .equals(modelsDTO.getName()))) {
            throw new NameAlreadyExist();
        }
    }

    private void isInstructorAssigned(InstructorAssignmentDTO instructorAssignmentDTO, Models models) {
        if (models.getInstructor()
                .stream()
                .anyMatch(instructorName -> instructorName.getName()
                        .equals(instructorAssignmentDTO.getInstructorName()))){
            throw new InstructorIsAssigned();
        }
    }

    public void assignUnavailableDaysByDuration(LocalDate periodStart, double duration, String instructorName) {
        Instructor instructor = (Instructor) instructorRepo.findByName(instructorName).orElseThrow();
        int traingDays = duration % 8 > 0 ? (int) duration / 8 + 1: (int) duration / 8;
        for (int i = 1; i <= traingDays; i++){
            InstructorUnavailableDays instructorUnavailableDays = new InstructorUnavailableDays();
            if (i > 1){
                instructorUnavailableDays.setUnavailableDay(periodStart.plusDays(i - 1));
                instructor.assignUnavailableDays(instructorUnavailableDays);
            } else {
                instructorUnavailableDays.setUnavailableDay(RentalStart);
                instructor.assignUnavailableDays(instructorUnavailableDays);
            }
        }
        instructorRepo.save(instructor);
    }

    public void addPeriod(RentalDTO rentalDTO,
                          String rentalId) {

            Models models = (Models) modelsRepo.findByFrontId(rentalId)
                    .orElseThrow(ModelsNotExist::new);

        isPeriodExist(rentalDTO, models);
        models.assignRental(mapper.modelsRentaldDTOtoModelsRental(rentalDTO));
            modelsRepo.save(models);
    }

    private void isPeriodExist(RentalDTO rentalDTO, Models models) {
        if (models.getRentalPeriod()
                .stream()
                .anyMatch(rentalPeriod -> rentalPeriod.getStartRental()
                        .equals(rentalDTO.getStartRental()))){
            throw new ModelsRentalExist();
        }
    }

    public void addPeriodAndInstructor(PeriodAndInstructorAssignDTO periodAndInstructorAssignDTO,
                                    String periodId) {
        addPeriod(periodAndInstructorAssignDTO.getRentalDTO(), periodId);
        Models models = modelsRepo.findByFrontId(periodId).orElseThrow();
        ModelsDTO modelsDTO= mapper.modelsToDTO(models);
        instructorService.addInstructor(periodAndInstructorAssignDTO.getInstructorDTO());
        instructorService.assignUnavailableDays(periodAndInstructorAssignDTO.getRentaldDTO(),
                periodAndInstructorAssignDTO.getInstructorDTO().getName());
        InstructorAssignmentDTO instructorAssignmentDTO = new InstructorAssignmentDTO(periodAndInstructorAssignDTO.getInstructorDTO().getName(), modelsDTO.getName());
        addInstructorToPeriod(instructorAssignmentDTO);
    }
}
*/
