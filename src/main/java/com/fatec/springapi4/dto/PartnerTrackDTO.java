package com.fatec.springapi4.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PartnerTrackDTO {
    private String name;
    private List<PartnerExpertiseDTO> expertises;
    
}