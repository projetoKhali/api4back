package com.fatec.api.service;

import java.util.List;

import com.fatec.api.entity.Partner;

public interface IPartnerService {
    
    public Partner findPartnerById(Long id);

    public List<Partner> listPartners ();

    public Partner saveAndUpdatePartner(Partner partner);

    public void delPartnerById (Long id);
    
}
