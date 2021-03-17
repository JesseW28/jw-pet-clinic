package com.jw.jwpetclinic.services;

import com.jw.jwpetclinic.model.BaseEntity;

import java.util.List;
import java.util.Set;

public interface CrudService<T extends BaseEntity> {

    T findById(Long id);

    T save(T entity);

    List<T> saveAll(List<T> entities);

    Set<T> findAll();

    void delete (T entity);

    void deleteById(Long id);
}
