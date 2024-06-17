package com.fatec.springapi4.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.AssociatePartner.PartnerTrackAssociateDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.PartnerTrackRepository;
import com.fatec.springapi4.repository.TrackRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartnerTrackService implements IPartnerTrackService {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    PartnerTrackRepository partnerTrackRepository;

    public void associatePartnerWithTrack(PartnerTrackAssociateDTO dto) {
        Long partnerId = dto.getPartnerId();
        Long trackId = dto.getTrackId();

        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (!partnerOptional.isPresent()) {
            throw new EntityNotFoundException("Parceiro não encontrado com o ID: " + partnerId);
        }
        Partner partner = partnerOptional.get();

        Optional<Track> trackOptional = trackRepository.findById(trackId);
        if (!trackOptional.isPresent()) {
            throw new EntityNotFoundException("Track não encontrada com o ID: " + trackId);
        }
        Track track = trackOptional.get();

        PartnerTrack partnerTrack = new PartnerTrack();
        partnerTrack.setPartner(partner);
        partnerTrack.setTrack(track);
        partnerTrack.setInsertDate(LocalDate.now());
        partnerTrackRepository.save(partnerTrack);
    }

}
