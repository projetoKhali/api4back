package com.fatec.springapi4.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.PartnerQualifierAssociateDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.QualifierRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartnerQualifierService implements IPartnerQualifierService {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    QualifierRepository qualifierRepository;

    @Autowired
    PartnerQualifierRepository partnerQualifierRepository;

    public void associatePartnerWithQualifier(PartnerQualifierAssociateDTO dto) {
        Long partnerId = dto.getPartnerId();
        Long qualifierId = dto.getQualifierId();

        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (!partnerOptional.isPresent()) {
            throw new EntityNotFoundException("Parceiro não encontrado com o ID: " + partnerId);
        }
        Partner partner = partnerOptional.get();

        Optional<Qualifier> qualifierOptional = qualifierRepository.findById(qualifierId);
        if (!qualifierOptional.isPresent()) {
            throw new EntityNotFoundException("Qualifier não encontrada com o ID: " + qualifierId);
        }
        Qualifier qualifier = qualifierOptional.get();

        PartnerQualifier partnerQualifier = new PartnerQualifier();
        partnerQualifier.setPartnerId(partner);
        partnerQualifier.setQualifierId(qualifier);
        partnerQualifier.setInsertDate(LocalDate.now());
        partnerQualifier.setCompleteDate(null);
        partnerQualifierRepository.save(partnerQualifier);
    }
}
