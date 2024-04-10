package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.PartnerTrack;

@Repository
public interface PartnerTrackRepository extends JpaRepository<PartnerTrack, Long> {
    List<PartnerTrack> findByPartnerId(Long partnerId);
    
}
