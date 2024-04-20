package com.fatec.springapi4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Partner;

import java.util.List;
import java.util.Optional;



@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findById(Long id);
/*
    @Query(value = "SELECT pt FROM Partner as pt " +
                    " WHERE pt.country in (:country)")
    public List<Partner> filterPartner(@Param("country") List<String> country);*/
}
