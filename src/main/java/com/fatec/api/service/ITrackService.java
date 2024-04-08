package com.fatec.api.service;

import java.util.List;

import com.fatec.api.entity.Track;

public interface ITrackService {

    public Track findTrackById(Long id);

    public List<Track> listTracks ();

    public Track saveAndUpdateTrack(Track track);

    public void delTrackById (Long id);
    
}