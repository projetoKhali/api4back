package com.fatec.springapi4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Qualifier;

@Repository
public interface QualifierRepository extends JpaRepository<Qualifier, Long> {
    Optional<Qualifier> findByName(String name);
    
}
