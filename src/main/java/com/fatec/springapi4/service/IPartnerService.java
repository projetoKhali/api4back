package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.DetailsPartner.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerQualifierDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerSimpleDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerTrackDTO;
import com.fatec.springapi4.entity.Partner;

public interface IPartnerService {
    
    public Partner findPartnerById(Long id);

    public List<Partner> listPartners ();

    public Partner saveAndUpdatePartner(Partner partner);

    public void delPartnerById (Long id);

    
    public PartnerSimpleDTO getPartnerWithDetails(Long partnerId);

    public List<PartnerTrackDTO> getAllPartnerTrackWithDetails(Partner partner);

    public List<PartnerExpertiseDTO> getAllPartnerExpertise(Partner partner);

    public List<PartnerQualifierDTO> getAllPartnerQualifier(Partner partner);

}
