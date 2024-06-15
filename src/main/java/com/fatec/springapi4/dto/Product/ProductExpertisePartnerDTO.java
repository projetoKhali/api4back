package com.fatec.springapi4.dto.Product;

import java.time.LocalDate;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.PartnerExpertise;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductExpertisePartnerDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProductExpertisePartnerDTO(Expertise expertise, PartnerExpertise partnerExpertise) {
        name = expertise.getName();
        startDate = partnerExpertise.getInsertDate();
        endDate = partnerExpertise.getCompleteDate();
    }
}
