package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.PartnerSimpleDTO;
import com.fatec.springapi4.dto.PartnerTrackAssociateDTO;
import com.fatec.springapi4.dto.PartnerQualifierDTO;
import com.fatec.springapi4.dto.PartnerTrackDTO;
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

@Service
public class PartnerService implements IPartnerService {

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
        if (partnerOptional.isPresent()) {
            return partnerOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Partner> listPartners() {
        return partnerRepository.findAll();
    }

    public Partner saveAndUpdatePartner(Partner partner) {
        if (partner == null ||
                partner.getName() == null) {
            throw new IllegalArgumentException("Error!");
        }
        return partnerRepository.save(partner);
    }

    public void delPartnerById(Long id) {
        partnerRepository.deleteById(id);
    }

    public PartnerSimpleDTO getPartnerSimple(Long partnerId) {
        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (partnerOptional.isPresent()) {
            Partner partner = partnerOptional.get();

            PartnerSimpleDTO partnerSimpleDTO = new PartnerSimpleDTO();
            partnerSimpleDTO.setName(partner.getName());
            partnerSimpleDTO.setLocation(partner.getCity());

            List<PartnerTrackDTO> partnerTrackDTOs = getAllPartnerTrack(partner);

            partnerSimpleDTO.setTracks(partnerTrackDTOs);

            return partnerSimpleDTO;
        } else {
            throw new IllegalArgumentException("Id de parceiro inválido!");
        }
    }

    public List<PartnerTrackDTO> getAllPartnerTrack(Partner partner) {
        List<PartnerTrack> partnerTracks = partnerTrackRepository.findByPartnerId(partner);
        List<PartnerTrackDTO> partnerTrackDTOs = new ArrayList<>();

        for (PartnerTrack partnerTrack : partnerTracks) {
            PartnerTrackDTO partnerTrackDTO = new PartnerTrackDTO();

            partnerTrackDTO.setName(partnerTrack.getTrackId().getName());

            List<PartnerExpertiseDTO> partnerExpertiseDTOs = getAllPartnerExpertise(partner); //TODOS AS EXPERTISES (TRACKS DIFERENTES)
            List<PartnerExpertiseDTO> partnerExpertiseDTOByTrack = new ArrayList<>();

            for (PartnerExpertiseDTO partnerExpertiseDTO : partnerExpertiseDTOs) {
                Expertise expertise = expertiseRepository.findByName(partnerExpertiseDTO.getName()).orElse(null);

                if (expertise != null && expertise.getTrack().getName().equals(partnerTrackDTO.getName())) {

                    partnerExpertiseDTOByTrack.add(partnerExpertiseDTO);
                }
            }

            partnerTrackDTO.setExpertises(partnerExpertiseDTOByTrack);

            partnerTrackDTOs.add(partnerTrackDTO);
        }

        return partnerTrackDTOs;
    }

    public List<PartnerExpertiseDTO> getAllPartnerExpertise(Partner partner) {
        List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartnerId(partner);
        List<PartnerExpertiseDTO> partnerExpertiseDTOs = new ArrayList<>();

        for (PartnerExpertise partnerExpertise : partnerExpertises) {
            PartnerExpertiseDTO partnerExpertiseDTO = new PartnerExpertiseDTO();

            partnerExpertiseDTO.setName(partnerExpertise.getExpertiseId().getName());

            List<PartnerQualifierDTO> partnerQualifierDTOs = getAllPartnerQualifier(partner);
            partnerExpertiseDTO.setQualifiers(partnerQualifierDTOs);

            partnerExpertiseDTOs.add(partnerExpertiseDTO);
        }

        return partnerExpertiseDTOs;
    }

    public List<PartnerExpertiseDTO> getAllPartnerExpertiseByTrack(Partner partner, PartnerTrack partnerTrack) {
    
        List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartnerId(partner);
        List<PartnerExpertiseDTO> partnerExpertiseDTOs = new ArrayList<>();

        for (PartnerExpertise partnerExpertise : partnerExpertises) {
            PartnerExpertiseDTO partnerExpertiseDTO = new PartnerExpertiseDTO();

            partnerExpertiseDTO.setName(partnerExpertise.getExpertiseId().getName());

            List<PartnerQualifierDTO> partnerQualifierDTOs = getAllPartnerQualifier(partner);
            partnerExpertiseDTO.setQualifiers(partnerQualifierDTOs);

            partnerExpertiseDTOs.add(partnerExpertiseDTO);
        }

        return partnerExpertiseDTOs;
    }

    public List<PartnerQualifierDTO> getAllPartnerQualifier(Partner partner) {
        List<PartnerQualifier> partnerQualifiers = partnerQualifierRepository.findByPartnerId(partner);
        List<PartnerQualifierDTO> partnerQualifierDTOs = new ArrayList<>();

        for (PartnerQualifier partnerQualifier : partnerQualifiers) {
            PartnerQualifierDTO partnerQualifierDTO = new PartnerQualifierDTO();

            partnerQualifierDTO.setName(partnerQualifier.getQualifierId().getName());

            partnerQualifierDTOs.add(partnerQualifierDTO);
        }

        return partnerQualifierDTOs;

    }

}
