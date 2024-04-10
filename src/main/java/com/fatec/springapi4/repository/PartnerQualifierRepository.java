package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.PartnerQualifier;

@Repository
public interface PartnerQualifierRepository extends JpaRepository<PartnerQualifier, Long> {
    List<PartnerQualifier> findByPartnerId(Long partnerId);
    
}
