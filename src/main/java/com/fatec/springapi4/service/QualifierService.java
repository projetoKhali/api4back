package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.Product.ProductQualifierPartnerDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.QualifierRepository;

@Service
public class QualifierService implements IQualifierService{

    @Autowired
    QualifierRepository qualifierRepository;

    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    PartnerQualifierRepository partQualRepository;


    public Qualifier findQualifierById(Long id) {
        Optional<Qualifier> qualifierOptional = qualifierRepository.findById(id);
        if(qualifierOptional.isPresent()) {
            return qualifierOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Qualifier> listQualifiers () {
        return qualifierRepository.findAll();
    }

    public Qualifier saveAndUpdateQualifier(Qualifier qualifier) {
        if(qualifier == null ||
            qualifier.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return qualifierRepository.save(qualifier);
        }
    
    public void delQualifierkById (Long id) {
        qualifierRepository.deleteById(id);
    }

    public List<ProductQualifierPartnerDTO> findQualifiersDTOByPartnerAndTrack (Track track, Partner partner) {
        List<Expertise> expertisesInTrack = expertiseRepository.findByTrack(track);
        List<ProductQualifierPartnerDTO> qualifiersTrackPartner = new ArrayList<ProductQualifierPartnerDTO>();
        Set<Long> idsUnicos = new HashSet<>();

        for(Expertise expertise : expertisesInTrack) {
            List<Qualifier> qualifiersInExp = qualifierRepository.getByExpertiseId(expertise.getId());
            for(Qualifier qualifier: qualifiersInExp){
                Optional<PartnerQualifier> partQual = partQualRepository.findByQualifierAndPartner(qualifier, partner);
                if (partQual.isEmpty()) {continue;}
                if (!idsUnicos.add(qualifier.getId())) {continue;} //impedir add de qualifiers iguais
                ProductQualifierPartnerDTO qualifierPartnerDTO = 
                    new ProductQualifierPartnerDTO(qualifier, partQual.get());
                qualifiersTrackPartner.add(qualifierPartnerDTO);
            }
        }
        return qualifiersTrackPartner;
    }

}
