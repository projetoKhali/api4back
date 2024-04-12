package com.fatec.springapi4.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Track;
import java.util.Optional;




@Repository
public interface TrackRepository  extends JpaRepository<Track, Long>{
    Optional<Track> findById(Long id);
    Optional<Track> findByName(String nameTrack);
    
    
}