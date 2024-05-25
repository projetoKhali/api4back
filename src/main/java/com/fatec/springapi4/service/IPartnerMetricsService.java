package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.PartnerMetrics;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPartnerMetricsService {

  public Page<PartnerMetrics> listPartnerMetrics(String partialName, Pageable pageable);

  public Optional<PartnerMetrics> listPartnerMetricById(Long id);
}
