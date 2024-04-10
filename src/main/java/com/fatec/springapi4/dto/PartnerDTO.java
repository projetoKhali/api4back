package com.fatec.springapi4.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PartnerDTO {
    private String name;
    private String location;
    private List<TrackDTO> tracks;
    
}
