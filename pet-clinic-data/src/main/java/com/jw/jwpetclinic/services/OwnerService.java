package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
