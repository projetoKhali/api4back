package com.fatec.springapi4.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.repository.QualifierRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductExpertiseDTO {
    private String name;
    private List<String> qualifiers;

    public ProductExpertiseDTO(String name, List<String> qualifiersName) {
        this.name = name;
        this.qualifiers = qualifiersName;
    }

    public ProductExpertiseDTO(Expertise expertise, QualifierRepository qualifierRepository) {
        name = expertise.getName();
        List<Qualifier> qualifiersList = qualifierRepository.getByExpertiseId(expertise.getId());
        qualifiers = new ArrayList<String>();
        for (Qualifier qualifier : qualifiersList) {
            qualifiers.add(qualifier.getName());
        }
    }

    public ProductExpertiseDTO(Optional<Expertise> expertise) {
        // TODO Auto-generated constructor stub
    }
}
