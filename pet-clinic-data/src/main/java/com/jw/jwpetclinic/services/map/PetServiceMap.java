package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.Pet;
import com.jw.jwpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }
}
