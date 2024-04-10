package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.PartnerSimpleDTO;
import com.fatec.springapi4.dto.PartnerQualifierDTO;
import com.fatec.springapi4.dto.PartnerTrackDTO;
import com.fatec.springapi4.dto.TrackDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.PartnerExpertiseRepository;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.PartnerTrackRepository;
import com.fatec.springapi4.repository.QualifierRepository;
import com.fatec.springapi4.repository.TrackRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartnerService implements IPartnerService{

    @Autowired
    PartnerRepository partnerRepository;
    
    @Autowired
    PartnerTrackRepository partnerTrackRepository;

    @Autowired
    PartnerExpertiseRepository partnerExpertiseRepository;

    @Autowired
    PartnerQualifierRepository partnerQualifierRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    QualifierRepository qualifierRepository;


    public Partner findPartnerById(Long id) {
        Optional<Partner> partnerOptional = partnerRepository.findById(id);
        if(partnerOptional.isPresent()) {
            return partnerOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Partner> listPartners () {
        return partnerRepository.findAll();
    }

    public Partner saveAndUpdatePartner(Partner partner) {
        if(partner == null ||
            partner.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return partnerRepository.save(partner);
        }
    
    public void delPartnerById (Long id) {
        partnerRepository.deleteById(id);
    }

    public PartnerSimpleDTO getPartnerSimple(Long partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new EntityNotFoundException("Partner not found with id: " + partnerId));

        PartnerSimpleDTO partnerSimpleDTO = new PartnerSimpleDTO();
        partnerSimpleDTO.setName(partner.getName());
        partnerSimpleDTO.setLocation(partner.getCity());
        
        return new PartnerSimpleDTO();
    }

    public List<PartnerTrackDTO> getPartnerTrack(Long partnerId) {
        List<PartnerTrack> partnerTracks = partnerTrackRepository.findByPartnerId(partnerId);
        List<PartnerTrackDTO> partnerTrackDTOs = new ArrayList<>();

        for (PartnerTrack partnerTrack : partnerTracks) {
            Long trackId = partnerTrack.getTrackId().getId();
            Optional<Track> optionalTrack = trackRepository.findById(trackId);

            if (optionalTrack.isPresent()) {
                Track track = optionalTrack.get();

                PartnerTrackDTO partnerTrackDTO = new PartnerTrackDTO();
                partnerTrackDTO.setName(track.getName());

                partnerTrackDTOs.add(partnerTrackDTO);
            }
        }
        
        return partnerTrackDTOs;
    }

    public List<PartnerExpertiseDTO> getPartnerExpertise(Long partnerId) {
        List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartnerId(partnerId);
        List<PartnerExpertiseDTO> partnerExpertiseDTOs = new ArrayList<>();

        for (PartnerExpertise partnerExpertise : partnerExpertises) {
            Long expertiseId = partnerExpertise.getExpertiseId().getId();
            Optional<Expertise> optionalExpertise = expertiseRepository.findById(expertiseId);

            if (optionalExpertise.isPresent()) {
                Expertise expertise = optionalExpertise.get();

                PartnerExpertiseDTO partnerExpertiseDTO = new PartnerExpertiseDTO();
                partnerExpertiseDTO.setName(expertise.getName());

                partnerExpertiseDTOs.add(partnerExpertiseDTO);
            }
        }
        
        return partnerExpertiseDTOs;
    }

    public List<PartnerQualifierDTO> getPartnerQuaifier(Long partnerId) {
        List<PartnerQualifier> partnerQualifiers = partnerQualifierRepository.findByPartnerId(partnerId);
        List<PartnerQualifierDTO> partnerQualifierDTOs = new ArrayList<>();

        for (PartnerQualifier partnerQualifier : partnerQualifiers) {
            Long qualifierId = partnerQualifier.getQualifierId().getId();
            Optional<Qualifier> optionalQualifier = qualifierRepository.findById(qualifierId);

            if (optionalQualifier.isPresent()) {
                Qualifier qualifier = optionalQualifier.get();

                PartnerQualifierDTO partnerQualifierDTO = new PartnerQualifierDTO();
                partnerQualifierDTO.setName(qualifier.getName());

                partnerQualifierDTOs.add(partnerQualifierDTO);
            }
        }
        
        return partnerQualifierDTOs;
    }
    
    
    
}
