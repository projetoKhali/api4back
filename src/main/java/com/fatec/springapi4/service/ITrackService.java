package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.Product.ProductTrackDTO;
import com.fatec.springapi4.entity.Track;

public interface ITrackService {

    public Track findTrackById(Long id);

    public List<Track> listTracks ();

    public Track saveAndUpdateTrack(Track track);

    public void delTrackById (Long id);

    public ProductTrackDTO findTrackDTOByName(String nameTrack);

    
}