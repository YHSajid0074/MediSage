package com.example.MediSage.generic.repository;

import com.example.MediSage.generic.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoRepositoryBean
public interface AbstractRepository<E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

    List<E> findAllByIdInAndIsActive(Set<Long> ids, Boolean isActive);

    Optional<E> findByIdAndIsActiveTrue(Long id);
    List<E> findAllByIdIn(Collection<Long> ids);

    List<E> findAllByIsActiveTrue();
}