package com.fatec.springapi4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertiseQualifierAssociateDTO {
    private Long expertiseId;
    private Long qualifierId;

}
