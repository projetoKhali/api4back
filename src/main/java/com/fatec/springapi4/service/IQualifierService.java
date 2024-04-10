package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.entity.Qualifier;

public interface IQualifierService {
    
    public Qualifier findQualifierById(Long id);

    public List<Qualifier> listQualifiers ();

    public Qualifier saveAndUpdateQualifier(Qualifier qualifier);

    public void delQualifierkById (Long id);

}
