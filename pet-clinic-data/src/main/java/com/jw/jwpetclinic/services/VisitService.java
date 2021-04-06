package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Visit;

import java.util.List;

public interface VisitService extends CrudService<Visit> {
    List<Visit> findByPetId(Long petId);
}
