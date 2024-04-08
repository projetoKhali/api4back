package com.fatec.api.service;

import java.util.List;

import com.fatec.api.entity.Qualifier;

public interface IQualifierService {
    
    public Qualifier findQualifierById(Long id);

    public List<Qualifier> listQualifiers ();

    public Qualifier saveAndUpdateQualifier(Qualifier qlf);

    public void delQualifierkById (Long id);

}
