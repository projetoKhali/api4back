package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.Product.ProductPartnerDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerQualifierDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerSimpleDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerTrackDTO;
import com.fatec.springapi4.entity.Partner;

public interface IPartnerService {
    
    public Partner findPartnerById(Long id);

    public List<Partner> listPartners ();

    public Partner saveAndUpdatePartner(Partner partner);

    public Partner updatePartnerField(Long id, String fieldName, String value);

    public void delPartnerById (Long id);

    public List<ProductPartnerDTO> findPartnersByTrack (String nameTrack);
    
    public PartnerSimpleDTO getPartnerWithDetails(Long partnerId);

    public List<PartnerTrackDTO> getAllPartnerTrackWithDetails(Partner partner);

    public List<PartnerExpertiseDTO> getAllPartnerExpertise(Partner partner);

    public List<PartnerQualifierDTO> getAllPartnerQualifier(Partner partner);

    public List<Partner> filterPartner(String country,Boolean compliance,Boolean credit, Boolean status,
                                       Boolean memberType);

}
