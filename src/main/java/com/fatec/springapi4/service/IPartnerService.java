package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.PartnerQualifierDTO;
import com.fatec.springapi4.dto.PartnerSimpleDTO;
import com.fatec.springapi4.dto.PartnerTrackDTO;
import com.fatec.springapi4.entity.Partner;

public interface IPartnerService {
    
    public Partner findPartnerById(Long id);

    public List<Partner> listPartners ();

    public Partner saveAndUpdatePartner(Partner partner);

    public void delPartnerById (Long id);

    public PartnerSimpleDTO getPartnerSimple(Long partnerId);

    public List<PartnerTrackDTO> getPartnerTrack(Long partnerId);

    public List<PartnerExpertiseDTO> getPartnerExpertise(Long partnerId);

    public List<PartnerQualifierDTO> getPartnerQuaifier(Long partnerId);
    
}
