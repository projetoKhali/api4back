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
    ExpertiseRepository expRep;

    public Expertise findExpertiseById(Long id) {
        Optional<Expertise> expOp = expRep.findById(id);
        if(expOp.isPresent()) {
            return expOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Expertise> listExpertises() {
        return expRep.findAll();
    }

    public Expertise saveAndUpdateExpertise(Expertise expertise) {
        if(expertise == null ||
        expertise.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return expRep.save(expertise);
        }

    public void delExpertiseById (Long id) {
        expRep.deleteById(id);
    }
}
