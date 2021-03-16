package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);
}
