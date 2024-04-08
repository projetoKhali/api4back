package com.fatec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.api.entity.Qualifier;

@Repository
public interface QualifierRepository extends JpaRepository<Qualifier, Long> {
    
}
