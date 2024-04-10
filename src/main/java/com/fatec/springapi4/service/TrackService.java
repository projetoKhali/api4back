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
    TrackRepository trackRepository;

    public Track findTrackById(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if(trackOptional.isPresent()) {
            return trackOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Track> listTracks () {
        return trackRepository.findAll();
    }

    public Track saveAndUpdateTrack(Track track) {
        if(track == null ||
            track.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return trackRepository.save(track);
        }
    
    public void delTrackById (Long id) {
        trackRepository.deleteById(id);
    }

}