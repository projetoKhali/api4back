package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.Product.ProductPartnerDTO;
import com.fatec.springapi4.entity.Partner;

public interface IPartnerService {
    
    public Partner findPartnerById(Long id);

    public List<Partner> listPartners ();

    public Partner saveAndUpdatePartner(Partner partner);

    public void delPartnerById (Long id);
    
    public List<ProductPartnerDTO> findPartnersByTrack (String nameTrack);
}
