package com.jw.jwpetclinic.bootstrap;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.model.Vet;
import com.jw.jwpetclinic.services.OwnerService;
import com.jw.jwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner("Jesse", "Wouters");
        Owner owner2 = new Owner("Karel", "Jansen");

        ownerService.save(owner);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet = new Vet("Peter", "Hoogeland");
        Vet vet2 = new Vet("Jan", "Breugeman");

        vetService.save(vet);
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
