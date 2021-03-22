package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Vet;
import com.jw.jwpetclinic.repositories.VetRepository;
import com.jw.jwpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetServiceJpa extends AbstractServiceJpa<Vet, VetRepository> implements VetService {

    private final VetRepository repository;

    public VetServiceJpa(VetRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
