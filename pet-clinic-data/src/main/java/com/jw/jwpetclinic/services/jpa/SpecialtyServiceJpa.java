package com.jw.jwpetclinic.services.jpa;


import com.jw.jwpetclinic.model.Specialty;
import com.jw.jwpetclinic.repositories.SpecialtyRepository;
import com.jw.jwpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialtyServiceJpa extends AbstractServiceJpa<Specialty, SpecialtyRepository> implements SpecialtyService {

    private final SpecialtyRepository repository;

    public SpecialtyServiceJpa(SpecialtyRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
