package com.fatec.springapi4.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.PartnerQualifierAssociateDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.QualifierRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartnerQualifierService {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    QualifierRepository qualifierRepository;

    @Autowired
    PartnerQualifierRepository partnerQualifierRepository;
    
   /*  public void associatePartnerWithQualifier(PartnerQualifierAssociateDTO dto) {
        Long partnerId = dto.getPartnerId();
        Long qualifierId = dto.getQualifierId();
        
        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (!partnerOptional.isPresent()) {
            throw new EntityNotFoundException("Parceiro não encontrado com o ID: " + partnerId);
        }
        Partner partner = partnerOptional.get();

        Optional<Qualifier> qualifier = expertiseRepository.findById(expertiseId);
        if (!expertiseOptional.isPresent()) {
            throw new EntityNotFoundException("Expertise não encontrada com o ID: " + expertiseId);
        }
        Expertise expertise = expertiseOptional.get();

        PartnerExpertise partnerExpertise = new PartnerExpertise();
        partnerExpertise.setPartnerId(partner);
        partnerExpertise.setExpertiseId(expertise);
        partnerExpertise.setInsertDate(LocalDate.now());
        partnerExpertise.setCompleteDate(LocalDate.now());
        partnerExpertiseRepository.save(partnerExpertise);
    }*/
}
