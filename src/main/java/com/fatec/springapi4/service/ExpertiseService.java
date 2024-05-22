package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.Product.ProductExpertiseDTO;
import com.fatec.springapi4.dto.Product.ProductExpertisePartnerDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.PartnerExpertiseRepository;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.QualifierRepository;
import com.fatec.springapi4.repository.TrackRepository;

@Service
public class ExpertiseService implements IExpertiseService {
    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    TrackRepository trackRepository;
    
    @Autowired
    QualifierRepository qualifierRepository;
    
    @Autowired
    PartnerExpertiseRepository partExpRepository;
    
    @Autowired
    PartnerQualifierRepository partQualRepository;

    public Expertise findExpertiseById(Long id) {
        Optional<Expertise> expertiseOptional = expertiseRepository.findById(id);
        if(expertiseOptional.isPresent()) {
            return expertiseOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Expertise> listExpertises() {
        return expertiseRepository.findAll();
    }

    public Expertise saveAndUpdateExpertise(Expertise expertise) {
        if(expertise == null ||
        expertise.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return expertiseRepository.save(expertise);
        }

    public void delExpertiseById (Long id) {
        expertiseRepository.deleteById(id);
    }

    public List<ProductExpertiseDTO> findExpertisesDTOByTrackId(Long trackId){
        Optional<Track> trackOptional = trackRepository.findById(trackId);
        if (trackOptional.isEmpty()) {return new ArrayList<ProductExpertiseDTO>();}
        List<Expertise> expertises = expertiseRepository.findByTrack(trackOptional.get());
        List<ProductExpertiseDTO> expertisesDTO = new ArrayList<ProductExpertiseDTO>();   
        for (Expertise expertise : expertises){
            ProductExpertiseDTO expertiseDTO = new ProductExpertiseDTO(expertise, qualifierRepository);
            expertisesDTO.add(expertiseDTO);
        }
        return expertisesDTO;
    }   

    public List<ProductExpertisePartnerDTO> findExpertisesDTOByPartnerAndTrack (Track track, Partner partner) {
        List<Expertise> expertisesInTrack = expertiseRepository.findByTrack(track);
        List<ProductExpertisePartnerDTO> expertisesTrackPartner = new ArrayList<ProductExpertisePartnerDTO>();

        for(Expertise expertise : expertisesInTrack) {
            Optional<PartnerExpertise> partExp = partExpRepository.findByExpertiseAndPartner(expertise, partner);
            if(partExp.isEmpty()){continue;}
            ProductExpertisePartnerDTO prodExpPartDTO = 
                new ProductExpertisePartnerDTO(expertise, partExp.get());
            expertisesTrackPartner.add(prodExpPartDTO);
            }
        return expertisesTrackPartner;
    }

    
}