package com.fatec.springapi4.dto;

import java.time.LocalDate;
import java.util.List;

public class ExpertiseDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<QualifierDTO> qualifiers;
    
}
