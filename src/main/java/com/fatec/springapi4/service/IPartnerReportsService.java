package com.fatec.springapi4.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fatec.springapi4.entity.PartnerReports;

public interface IPartnerReportsService {
    
    public Page<PartnerReports> listPartnerReports(int pageNumber, int pageSize);

    public List<PartnerReports> listPartnerReportsById(Long id);

}
