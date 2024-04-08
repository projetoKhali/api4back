package com.fatec.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.api.entity.Partner;
import com.fatec.api.repository.PartnerRepository;

@Service
public class PartnerService implements IPartnerService{

    @Autowired
    PartnerRepository partnerRep;

    public Partner findPartnerById(Long id) {
        Optional<Partner> partnerOp = partnerRep.findById(id);
        if(partnerOp.isPresent()) {
            return partnerOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public List<Partner> listPartners () {
        return partnerRep.findAll();
    }

    public Partner saveAndUpdatePartner(Partner partner) {
        if(partner == null ||
            partner.getName() == null) {
                throw new IllegalArgumentException("Error!");
            }
            return partnerRep.save(partner);
        }
    
    public void delPartnerById (Long id) {
        partnerRep.deleteById(id);
    }
    
}
