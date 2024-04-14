package com.fatec.springapi4.dto.Product;

import java.time.LocalDate;
import java.util.List;

import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerTrack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductPartnerDTO {
    private String name;
    private LocalDate startDate;
    private String location;
    private List<ProductExpertisePartnerDTO> expertises;
    private List<ProductQualifierPartnerDTO> qualifiers;

    public ProductPartnerDTO(Partner partner, 
        PartnerTrack partnerTrack, 
        List<ProductExpertisePartnerDTO> expertises,
        List<ProductQualifierPartnerDTO> qualifiers) {
            name = partner.getName();
            startDate = partnerTrack.getInsertDate();
            location = partner.getCity();
            this.expertises = expertises; 
            this.qualifiers = qualifiers; 
    }
}
