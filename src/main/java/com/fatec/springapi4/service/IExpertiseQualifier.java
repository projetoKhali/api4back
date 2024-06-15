package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.ExpertiseQualifierAssociateDTO;

public interface IExpertiseQualifier {

    public void associateExpertiseWithQualifier(ExpertiseQualifierAssociateDTO dto);

    public List<ExpertiseQualifierAssociateDTO> getAllExpertiseQualifier();
}
