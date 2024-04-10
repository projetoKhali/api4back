package com.fatec.springapi4.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PartnerExpertiseDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<PartnerQualifierDTO> qualifiers;
    
}
