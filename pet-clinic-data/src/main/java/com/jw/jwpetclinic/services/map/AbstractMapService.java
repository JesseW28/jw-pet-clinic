package com.jw.jwpetclinic.services.map;

import com.jw.jwpetclinic.model.BaseEntity;
import com.jw.jwpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(Long id) {
        return map.get(id);
    }

    @Override
    public T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(getNextId());
        }
        map.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public void delete(T entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    private Long getNextId() {
        return map.keySet().isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
