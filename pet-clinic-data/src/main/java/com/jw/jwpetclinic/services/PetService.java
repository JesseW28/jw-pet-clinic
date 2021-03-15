package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
