package com.fatec.springapi4.dto.DetailsPartner;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertiseQualifierDTO {
    private String name;
    private List<PartnerQualifierDTO> qualifiers;
}
