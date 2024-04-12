package com.fatec.springapi4.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Qualifier;

public class ProductExpertiseDTO {
    private String name;
    private List<String> qualifiersName;
    
    public ProductExpertiseDTO(String name, List<String> qualifiersName) {
        this.name = name;
        this.qualifiersName = qualifiersName;
    }
    
    public ProductExpertiseDTO(Expertise expertise) {
        name = expertise.getName();
        List<Qualifier> qualifiers = expertise.getQualifiers();
        List<String> qualifiersName = new ArrayList<String>();
        for(Qualifier qualifier : qualifiers) {qualifiersName.add(qualifier.getName());}
    }

    public ProductExpertiseDTO(Optional<Expertise> expertise) {
        //TODO Auto-generated constructor stub
    }
}
