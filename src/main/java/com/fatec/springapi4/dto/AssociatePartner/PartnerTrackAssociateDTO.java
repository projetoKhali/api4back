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
public class PartnerTrackAssociateDTO {
    private Long partnerId;
    private Long trackId;
    private LocalDate insertDate;
    private LocalDate completeDate;
}
