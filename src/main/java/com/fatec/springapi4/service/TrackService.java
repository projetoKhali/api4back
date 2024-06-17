package com.fatec.springapi4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.Product.ProductExpertiseDTO;
import com.fatec.springapi4.dto.Product.ProductPartnerDTO;
import com.fatec.springapi4.dto.Product.ProductTrackDTO;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.TrackRepository;

@Service
public class TrackService implements ITrackService {

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    ExpertiseService expertiseService;

    @Autowired
    PartnerService partnerService;

    public Track findTrackById(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            return trackOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Track> listTracks() {
        return trackRepository.findAll();
    }

    public Track saveAndUpdateTrack(Track track) {
        if (track == null ||
                track.getName() == null) {
            throw new IllegalArgumentException("Error!");
        }
        return trackRepository.save(track);
    }

    public void delTrackById(Long id) {
        trackRepository.deleteById(id);
    }

    public ProductTrackDTO findTrackDTOById(Long trackId) {
        List<ProductExpertiseDTO> expertises = expertiseService.findExpertisesDTOByTrackId(trackId);
        List<ProductPartnerDTO> partners = partnerService.findPartnersByTrack(trackId);
        Optional<Track> track = trackRepository.findById(trackId);
        String nameTrack = (track.get()).getName();
        ProductTrackDTO trackDTO = new ProductTrackDTO(
                nameTrack,
                expertises,
                partners);
        return trackDTO;
    }
}
