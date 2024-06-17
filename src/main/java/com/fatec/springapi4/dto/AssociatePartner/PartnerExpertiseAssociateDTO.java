package com.fatec.springapi4.dto.AssociatePartner;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerExpertiseAssociateDTO {
    private Long partnerId;
    private Long expertiseId;
    private LocalDate insertDate;
    private LocalDate completeDate;
}
