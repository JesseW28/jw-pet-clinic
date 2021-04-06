package com.jw.jwpetclinic.repositories;

import com.jw.jwpetclinic.model.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends EntityRepository<Visit>{

    List<Visit> findByPetId(Long petId);
}
