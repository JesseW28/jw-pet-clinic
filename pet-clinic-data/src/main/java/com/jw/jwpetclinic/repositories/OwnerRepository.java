package com.jw.jwpetclinic.repositories;

import com.jw.jwpetclinic.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends EntityRepository<Owner>{

    Optional<Owner> findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
