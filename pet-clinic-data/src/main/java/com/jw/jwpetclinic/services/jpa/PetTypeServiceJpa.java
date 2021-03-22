package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.PetType;
import com.jw.jwpetclinic.repositories.PetTypeRepository;
import com.jw.jwpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeServiceJpa extends AbstractServiceJpa<PetType, PetTypeRepository> implements PetTypeService {

    private final PetTypeRepository repository;

    public PetTypeServiceJpa(PetTypeRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
