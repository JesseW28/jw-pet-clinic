package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.repositories.OwnerRepository;
import com.jw.jwpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("jpa")
public class OwnerServiceJpa extends AbstractServiceJpa<Owner, OwnerRepository> implements OwnerService {

    private final OwnerRepository repository;

    public OwnerServiceJpa(OwnerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

}
