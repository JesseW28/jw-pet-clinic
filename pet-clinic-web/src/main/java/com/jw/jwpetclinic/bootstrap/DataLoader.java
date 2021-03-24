package com.jw.jwpetclinic.bootstrap;

import com.jw.jwpetclinic.model.*;
import com.jw.jwpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType("dog");
        PetType bird = new PetType("bird");
        PetType cat = new PetType("cat");

        PetType savedBirdType = petTypeService.save(bird);
        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Owner owner1 = Owner.builder().firstName("Jesse").lastName("Wouters").build();
        owner1.setAddress("Lange weg 32");
        owner1.setCity("Rotterdam");
        owner1.setTelephone("0645364856");

        Pet jessePet = new Pet("Rex");
        jessePet.setPetType(savedDogType);
        jessePet.setOwner(owner1);
        jessePet.setBirthDate(LocalDate.now());
        owner1.getPets().add(jessePet);

        Owner owner2 = Owner.builder().firstName("Karel").lastName("Jansen").build();
        owner2.setAddress("Breedneude 12");
        owner2.setCity("Groningen");
        owner2.setTelephone("0645365856");

        Pet karelPet = new Pet("Minoes");
        karelPet.setPetType(savedCatType);
        karelPet.setOwner(owner2);
        karelPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(karelPet);

        ownerService.saveAll(Arrays.asList(owner1, owner2));

        System.out.println("Loaded owners...");

        Specialty radiology = new Specialty("radiology");
        Specialty dentistry = new Specialty("dentistry");
        Specialty surgery = new Specialty("surgery");

        Vet vet = Vet.builder().firstName("Peter").lastName("Hoogeland").build();
        vet.getSpecialties().add(specialtyService.save(radiology));
        Vet vet2 =  Vet.builder().firstName("Jan").lastName("Breugeman").build();
        vet2.getSpecialties().add(specialtyService.save(surgery));

        vetService.saveAll(Arrays.asList(vet, vet2));

        System.out.println("Loaded specialties...");
        System.out.println("Loaded vets...");

        Visit karelPetVisit = new Visit();
        karelPetVisit.setPet(karelPet);
        karelPetVisit.setDescription("Surgery to paws");

        Visit jessePetVisit = new Visit();
        jessePetVisit.setPet(jessePet);
        jessePetVisit.setDescription("Tooth removal");

        visitService.saveAll(Arrays.asList(karelPetVisit, jessePetVisit));
    }
}
