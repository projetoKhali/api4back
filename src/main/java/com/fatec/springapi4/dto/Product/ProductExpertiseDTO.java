package com.fatec.springapi4.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.repository.QualifierRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductExpertiseDTO {
    private String name;
    private List<String> qualifiersName;
    
    public ProductExpertiseDTO(String name, List<String> qualifiersName) {
        this.name = name;
        this.qualifiersName = qualifiersName;
    }
    
    public ProductExpertiseDTO(Expertise expertise, QualifierRepository qualifierRepository) {
        name = expertise.getName();
        List<Qualifier> qualifiers = qualifierRepository.getByExpertiseId(expertise.getId());
        List<String> qualifiersName = new ArrayList<String>();
        for(Qualifier qualifier : qualifiers) {
            qualifiersName.add(qualifier.getName());
        }
    }

    public ProductExpertiseDTO(Optional<Expertise> expertise) {
        //TODO Auto-generated constructor stub
    }
}
