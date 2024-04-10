package com.fatec.springapi4.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Track;



@Repository
public interface TrackRepository  extends JpaRepository<Track, Long>{
    
}