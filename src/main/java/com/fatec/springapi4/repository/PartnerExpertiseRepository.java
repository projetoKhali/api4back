package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.PartnerExpertise;

@Repository
public interface PartnerExpertiseRepository extends JpaRepository<PartnerExpertise, Long>{
    List<PartnerExpertise> findByPartnerId(Long partnerId);
    
}
