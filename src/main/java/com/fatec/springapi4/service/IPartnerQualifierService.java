package com.fatec.springapi4.service;

import com.fatec.springapi4.dto.AssociatePartner.PartnerQualifierAssociateDTO;

public interface IPartnerQualifierService {
    public void associatePartnerWithQualifier(PartnerQualifierAssociateDTO dto);
}
