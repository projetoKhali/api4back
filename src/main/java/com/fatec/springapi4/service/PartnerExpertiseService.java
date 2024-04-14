package com.fatec.springapi4.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.AssociatePartner.PartnerExpertiseAssociateDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.PartnerExpertiseRepository;
import com.fatec.springapi4.repository.PartnerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartnerExpertiseService implements IPartnerExpertiseService{

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    PartnerExpertiseRepository partnerExpertiseRepository;

    public void associatePartnerWithExpertise(PartnerExpertiseAssociateDTO dto) {
        Long partnerId = dto.getPartnerId();
        Long expertiseId = dto.getExpertiseId();
        
        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (!partnerOptional.isPresent()) {
            throw new EntityNotFoundException("Parceiro não encontrado com o ID: " + partnerId);
        }
        Partner partner = partnerOptional.get();

        Optional<Expertise> expertiseOptional = expertiseRepository.findById(expertiseId);
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
    }

}
