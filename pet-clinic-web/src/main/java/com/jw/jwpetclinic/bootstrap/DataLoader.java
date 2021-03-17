package com.jw.jwpetclinic.bootstrap;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.model.PetType;
import com.jw.jwpetclinic.model.Vet;
import com.jw.jwpetclinic.services.OwnerService;
import com.jw.jwpetclinic.services.PetTypeService;
import com.jw.jwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType("dog");
        PetType bird = new PetType("bird");
        PetType cat = new PetType("cat");

        PetType savedDogType = petTypeService.save(dog);
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");


        Owner owner1 = new Owner("Jesse", "Wouters");
        owner1.setAddress("Lange weg 32");
        owner1.setCity("Rotterdam");
        owner1.setTelephone("0645364856");

        Pet jessePet = new Pet("Rex");
        jessePet.setPetType(savedDogType);
        jessePet.setOwner(owner1);
        jessePet.setBirthDate(LocalDate.now());
        owner1.getPets().add(jessePet);

        Owner owner2 = new Owner("Karel", "Jansen");
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

        Vet vet = new Vet("Peter", "Hoogeland");
        Vet vet2 = new Vet("Jan", "Breugeman");

        vetService.saveAll(Arrays.asList(vet, vet2));

        System.out.println("Loaded vets...");

    }
}
