package com.jw.jwpetclinic.services.jpa;

import com.jw.jwpetclinic.model.BaseEntity;
import com.jw.jwpetclinic.repositories.EntityRepository;
import com.jw.jwpetclinic.services.CrudService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity, R extends EntityRepository<T>> implements CrudService<T> {

    private final R repository;

    protected AbstractJpaService(R repository) {
        this.repository = repository;
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
