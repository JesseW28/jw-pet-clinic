package com.jw.jwpetclinic.repositories;

import com.jw.jwpetclinic.model.Owner;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends EntityRepository<Owner>{

    Owner findByLastName(String lastName);
}
