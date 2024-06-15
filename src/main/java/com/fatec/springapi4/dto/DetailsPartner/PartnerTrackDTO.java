package com.fatec.springapi4.dto.DetailsPartner;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerTrackDTO {
    private String name;
    private LocalDate insertDate;
    private LocalDate completeDate;
    private List<PartnerExpertiseDTO> expertises;

}
