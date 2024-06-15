package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.ExpertiseQualifierAssociateDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.ExpertiseQualifier;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.repository.ExpertiseQualifierRepository;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.QualifierRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExpertiseQualifierService implements IExpertiseQualifier {

    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    QualifierRepository qualifierRepository;

    @Autowired
    ExpertiseQualifierRepository expertiseQualifierRepository;

    public void associateExpertiseWithQualifier(ExpertiseQualifierAssociateDTO dto) {
        Long expertiseId = dto.getExpertiseId();
        Long qualifierId = dto.getQualifierId();

        Optional<Expertise> expertiseOptional = expertiseRepository.findById(expertiseId);

        if (!expertiseOptional.isPresent()) {
            throw new EntityNotFoundException("Expertise não encontrada com o ID: " + expertiseId);
        }
        Expertise expertise = expertiseOptional.get();

        Optional<Qualifier> qualifierOptional = qualifierRepository.findById(qualifierId);
        if (!qualifierOptional.isPresent()) {
            throw new EntityNotFoundException("Qualifier não encontrada com o ID: " + qualifierId);
        }
        Qualifier qualifier = qualifierOptional.get();

        ExpertiseQualifier expertiseQualifier = new ExpertiseQualifier();
        expertiseQualifier.setExpertise(expertise);
        expertiseQualifier.setQualifier(qualifier);
        expertiseQualifierRepository.save(expertiseQualifier);
    }

    public List<ExpertiseQualifierAssociateDTO> getAllExpertiseQualifier() {
        List<ExpertiseQualifier> expertiseQualifiers = expertiseQualifierRepository.findAll();
        List<ExpertiseQualifierAssociateDTO> expertiseQualifierAssociateDTOs = new ArrayList<>();

        for (ExpertiseQualifier expertiseQualifier : expertiseQualifiers) {
            ExpertiseQualifierAssociateDTO dto = new ExpertiseQualifierAssociateDTO();

            dto.setExpertiseId(expertiseQualifier.getExpertise().getId());
            dto.setQualifierId(expertiseQualifier.getQualifier().getId());

            expertiseQualifierAssociateDTOs.add(dto);
        }

        return expertiseQualifierAssociateDTOs;

    }
}
