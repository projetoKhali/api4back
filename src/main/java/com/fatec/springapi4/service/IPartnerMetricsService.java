package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.entity.PartnerMetrics;

public interface IPartnerMetricsService {

    public List<PartnerMetrics> listPartnerMetrics();

    public List<PartnerMetrics> listPartnerMetricById(Long id);

}
