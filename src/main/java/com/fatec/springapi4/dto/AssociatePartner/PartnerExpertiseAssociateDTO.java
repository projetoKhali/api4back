package com.fatec.springapi4.dto.AssociatePartner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PartnerExpertiseAssociateDTO {
    private Long partnerId;
    private Long expertiseId;
    
}
