package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity, ID> {

    T findById(ID id);

    T save(T entity);

    Set<T> findAll();

    void delete (T entity);

    void deleteById(ID id);
}
