package com.fatec.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.api.entity.Track;



@Repository
public interface TrackRepository  extends JpaRepository<Track, Long>{
    
}