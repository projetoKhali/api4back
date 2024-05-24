package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.PartnerMetrics;
import com.fatec.springapi4.repository.PartnerMetricsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartnerMetricsService implements IPartnerMetricsService {

  @Autowired private PartnerMetricsRepository partnerMetricsRepository;

  public Page<PartnerMetrics> listPartnerMetrics(String partialName, Pageable pageable) {
    return partnerMetricsRepository.findByPartialName(partialName, pageable);
  }

  public List<PartnerMetrics> listPartnerMetricById(Long id) {
    return partnerMetricsRepository.findByPartnerId(id);
  }
}
