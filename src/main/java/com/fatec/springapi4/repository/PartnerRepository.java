package com.fatec.springapi4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Partner;

import java.util.Optional;





@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    
    @SuppressWarnings("null")
    Optional<Partner> findById(Long id);
    Optional<Partner> findByName(String name);
    
}
