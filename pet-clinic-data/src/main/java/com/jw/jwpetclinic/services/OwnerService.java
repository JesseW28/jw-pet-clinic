package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService extends CrudService<Owner> {

    Optional<Owner> findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
