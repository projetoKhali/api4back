package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.Product.ProductPartnerDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.PartnerExpertiseRepository;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.PartnerTrackRepository;
import com.fatec.springapi4.repository.QualifierRepository;
import com.fatec.springapi4.repository.TrackRepository;


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
    
    @Autowired
    ExpertiseService expertiseService;
    
    @Autowired
    QualifierService qualifierService;


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

    public List<ProductPartnerDTO> findPartnersByTrack (String nameTrack) {
        Optional<Track> track = trackRepository.findByName(nameTrack);
        List<PartnerTrack> partnersTracks = partnerTrackRepository.findByTrack(track);
        List<ProductPartnerDTO> partnersDTO = new ArrayList<ProductPartnerDTO>();
        if (track.isEmpty()) {return partnersDTO;}
        for (PartnerTrack partnerTrack : partnersTracks) {
            Optional<Partner> partnerOptional = partnerRepository.findById(partnerTrack.getId());
            if (partnerOptional.isEmpty()) {continue;}
            ProductPartnerDTO partnerDTO = 
                new ProductPartnerDTO(
                    partnerOptional.get(), 
                    partnerTrack, 
                    expertiseService.findExpertisesDTOByPartnerAndTrack (track.get(), partnerOptional.get()),
                    qualifierService.findQualifiersDTOByPartnerAndTrack (track.get(), partnerOptional.get()));
            partnersDTO.add(partnerDTO);
        }
        return partnersDTO;
    }
}
