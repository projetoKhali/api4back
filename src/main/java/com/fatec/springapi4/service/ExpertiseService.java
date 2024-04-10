package com.fatec.springapi4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.repository.ExpertiseRepository;

@Service
public class ExpertiseService implements IExpertiseService {
    @Autowired
    ExpertiseRepository expertiseRepository;

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
}
