package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {

    Owner findByLastName(String lastName);
}
