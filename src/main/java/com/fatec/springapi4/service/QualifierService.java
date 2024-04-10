package com.fatec.springapi4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.repository.QualifierRepository;

@Service
public class QualifierService implements IQualifierService{

    @Autowired
    QualifierRepository qualifierRepository;

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

}
