package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.ExpertiseQualifier;


public interface ExpertiseQualifierRepository extends JpaRepository<ExpertiseQualifier, Long>{
    List<ExpertiseQualifier> findByExpertiseId(Expertise expertise);
    List<ExpertiseQualifier> findByExpertise(Expertise expertise);
    boolean existsByExpertiseIdAndQualifierId(Long expertiseId, Long qualifierId);
    
}
