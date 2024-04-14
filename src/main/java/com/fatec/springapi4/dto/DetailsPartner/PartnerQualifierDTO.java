package com.fatec.springapi4.dto.DetailsPartner;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PartnerQualifierDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    
}
