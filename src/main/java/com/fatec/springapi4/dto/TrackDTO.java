package com.fatec.springapi4.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TrackDTO {
    private String name;
    private List<ExpertiseDTO> expertises;
    
}
