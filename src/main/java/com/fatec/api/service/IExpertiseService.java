package com.fatec.api.service;

import java.util.List;

import com.fatec.api.entity.Expertise;

public interface IExpertiseService {
    
    public Expertise findExpertiseById(Long id);

    public List<Expertise> listExpertises();
    
    public Expertise saveAndUpdateExpertise(Expertise expertise);

    public void delExpertiseById (Long id);

}
