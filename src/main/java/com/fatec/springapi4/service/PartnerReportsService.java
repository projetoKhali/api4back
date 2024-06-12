package com.fatec.springapi4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.PartnerReports;
import com.fatec.springapi4.repository.PartnerReportsRepository;

@Service
public class PartnerReportsService implements IPartnerReportsService{

    @Autowired
    PartnerReportsRepository partnerReportsRepository;

    public Page<PartnerReports> listPartnerReports(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return partnerReportsRepository.findAll(pageable);
    }

    public List<PartnerReports> listPartnerReportsById(Long id){
        return partnerReportsRepository.findByPartnerId(id);
    } 
}
