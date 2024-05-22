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

import com.fatec.springapi4.dto.Product.ProductTrackDTO;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.service.ITrackService;

@RestController
@CrossOrigin
@RequestMapping(value = "/track")
public class TrackController {

    @Autowired
    private ITrackService trackService;

    @GetMapping(value = "/{track}")
    public Track findById(@PathVariable("track") Long id) {
        return trackService.findTrackById(id);
    }

    @GetMapping
    public List<Track> listTracks() {
        return trackService.listTracks();
    }

    @PostMapping
    public Track saveAndUpdateTrack(@RequestBody Track track) {
        return trackService.saveAndUpdateTrack(track);
    }

    @DeleteMapping(value = "/{trackId}")
    public void deleteById(@PathVariable("trackId") Long id) {
        trackService.delTrackById(id);
    }

    @GetMapping(value = "/product/{trackId}")
    public ProductTrackDTO findTrackDTOByTrackId(@PathVariable("trackId") Long trackId) {
        return trackService.findTrackDTOById(trackId);
    }

    
}
