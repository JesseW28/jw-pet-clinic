package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.repositories.PetRepository;
import com.jw.jwpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetServiceJpa extends AbstractServiceJpa<Pet, PetRepository> implements PetService {

    private final PetRepository repository;

    public PetServiceJpa(PetRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
