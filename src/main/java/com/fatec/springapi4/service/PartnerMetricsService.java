package com.fatec.springapi4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.PartnerMetrics;
import com.fatec.springapi4.repository.PartnerMetricsRepository;

@Service
public class PartnerMetricsService implements IPartnerMetricsService {

    @Autowired
    private PartnerMetricsRepository partnerMetricsRepository;

    public List<PartnerMetrics> listPartnerMetrics() {
        return partnerMetricsRepository.findAll();
    }

    public List<PartnerMetrics> listPartnerMetricById(Long id) {
        return partnerMetricsRepository.findByPartnerId(id);
    }
}
