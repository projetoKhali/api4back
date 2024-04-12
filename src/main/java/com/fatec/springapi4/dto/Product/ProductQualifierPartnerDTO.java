package com.fatec.springapi4.dto.Product;

import java.time.LocalDate;

import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.Qualifier;

public class ProductQualifierPartnerDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProductQualifierPartnerDTO(Qualifier qualifier, PartnerQualifier partnerQualifier) {
        name = qualifier.getName();
        startDate = partnerQualifier.getInsertDate();
        endDate = partnerQualifier.getCompleteDate();
    }
    
}
