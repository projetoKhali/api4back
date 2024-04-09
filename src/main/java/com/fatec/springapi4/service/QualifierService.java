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
    QualifierRepository qlREp;

    public Qualifier findQualifierById(Long id) {
        Optional<Qualifier> qlOp = qlREp.findById(id);
        if(qlOp.isPresent()) {
            return qlOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Qualifier> listQualifiers () {
        return qlREp.findAll();
    }

    public Qualifier saveAndUpdateQualifier(Qualifier qlf) {
        if(qlf == null ||
            qlf.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return qlREp.save(qlf);
        }
    
    public void delQualifierkById (Long id) {
        qlREp.deleteById(id);
    }

}
