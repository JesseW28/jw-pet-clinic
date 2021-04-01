package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Owner;
import com.jw.jwpetclinic.repositories.OwnerRepository;
import com.jw.jwpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("jpa")
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

    private final OwnerRepository repository;

    public OwnerJpaService(OwnerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return repository.findAllByLastNameLike(lastName);
    }

}
