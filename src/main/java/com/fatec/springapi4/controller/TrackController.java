package com.fatec.springapi4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.service.ITrackService;

@RestController
@CrossOrigin
@RequestMapping(value = "/track")
public class TrackController {

    @Autowired
    private ITrackService trackServ;

    @GetMapping(value = "/{track}")
    public Track findById(@PathVariable("track") Long id) {
        return trackServ.findTrackById(id);
    }

    @GetMapping
    public List<Track> listTracks() {
        return trackServ.listTracks();
    }

    @PostMapping
    public Track saveAndUpdateTrack(@RequestBody Track track) {
        return trackServ.saveAndUpdateTrack(track);
    }

    @DeleteMapping(value = "/{trackId}")
    public void deleteById(@PathVariable("trackId") Long id) {
        trackServ.delTrackById(id);
    }

    
}
