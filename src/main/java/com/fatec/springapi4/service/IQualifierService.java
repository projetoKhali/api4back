package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.Product.ProductQualifierPartnerDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.entity.Track;

public interface IQualifierService {

    public Qualifier findQualifierById(Long id);

    public List<Qualifier> listQualifiers();

    public Qualifier saveAndUpdateQualifier(Qualifier qualifier);

    public void delQualifierkById(Long id);

    public List<ProductQualifierPartnerDTO> findQualifiersDTOByPartnerAndTrack(Track track, Partner partner);

}
