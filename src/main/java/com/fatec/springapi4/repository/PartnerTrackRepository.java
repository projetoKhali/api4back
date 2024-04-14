package com.fatec.springapi4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Track;

@Repository
public interface PartnerTrackRepository extends JpaRepository<PartnerTrack, Long> {
    List<PartnerTrack> findByPartner(Partner partner);
    List<PartnerTrack> findByTrack(Track track);
    
}
