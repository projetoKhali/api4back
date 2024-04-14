package com.fatec.springapi4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Expertise;
import java.util.List;

import com.fatec.springapi4.entity.Track;


@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long>{
    List<Expertise> findByTrack(Track track);
    Optional<Expertise> findByName(String name);
}
