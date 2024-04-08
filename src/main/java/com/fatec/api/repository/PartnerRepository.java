package com.fatec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.api.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    
}
