package com.fatec.springapi4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    
}
