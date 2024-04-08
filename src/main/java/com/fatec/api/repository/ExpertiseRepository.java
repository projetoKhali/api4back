package com.fatec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.api.entity.Expertise;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long>{
    
}
