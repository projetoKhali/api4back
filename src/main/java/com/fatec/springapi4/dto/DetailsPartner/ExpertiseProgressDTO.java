package com.fatec.springapi4.dto.DetailsPartner;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ExpertiseProgressDTO {
    private String expertise;
    private List<ExpertiseQualifierProgressDTO> partners;
    
}