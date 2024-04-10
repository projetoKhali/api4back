package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.ExpertiseDTO;
import com.fatec.springapi4.dto.PartnerDTO;
import com.fatec.springapi4.dto.QualifierDTO;
import com.fatec.springapi4.dto.TrackDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.entity.Track;
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
    
}