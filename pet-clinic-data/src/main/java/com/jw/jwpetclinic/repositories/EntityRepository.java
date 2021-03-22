package com.jw.jwpetclinic.repositories;

import com.jw.jwpetclinic.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
