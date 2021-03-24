package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.Visit;
import com.jw.jwpetclinic.repositories.VisitRepository;
import com.jw.jwpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {

    private final VisitRepository repository;

    public VisitJpaService(VisitRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
