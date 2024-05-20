package com.fatec.springapi4.dto.DetailsPartner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ExpertiseQualifierProgressDTO {
    private String partnerName;
    private String location;
    private Long qualifiersExpertise;
    private Long finalizedQualifiers;

}
