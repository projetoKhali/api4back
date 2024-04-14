package com.fatec.springapi4.dto.Product;

import java.util.List;
import java.util.Set;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductTrackDTO {
    private String nameTrack;
    private List<ProductExpertiseDTO> expertises;
    private List<ProductPartnerDTO> partners;
    
    public ProductTrackDTO(
        String nameTrack, 
        List<ProductExpertiseDTO> expertises, 
        List<ProductPartnerDTO> partners){
            this.nameTrack = nameTrack;
            this.expertises = expertises;
            this.partners = partners;
    }
}
