package com.fatec.springapi4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Expertise;


@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long>{
    Optional<Expertise> findByName(String name);
}
