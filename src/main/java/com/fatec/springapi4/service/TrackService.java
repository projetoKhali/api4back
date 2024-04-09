package com.fatec.springapi4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.TrackRepository;

@Service
public class TrackService implements ITrackService {

    @Autowired
    TrackRepository trackRep;

    public Track findTrackById(Long id) {
        Optional<Track> trackOp = trackRep.findById(id);
        if(trackOp.isPresent()) {
            return trackOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Track> listTracks () {
        return trackRep.findAll();
    }

    public Track saveAndUpdateTrack(Track track) {
        if(track == null ||
            track.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return trackRep.save(track);
        }
    
    public void delTrackById (Long id) {
        trackRep.deleteById(id);
    }

}