package com.fatec.springapi4.controller;

import com.fatec.springapi4.entity.PartnerMetrics;
import com.fatec.springapi4.service.IPartnerMetricsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/partnerMetrics")
public class PartnerMetricsController {

  @Autowired private IPartnerMetricsService iPartnerMetricsService;

  @GetMapping
  public Page<PartnerMetrics> allPartnerMetrics(
      @RequestParam(value = "partialName", required = false) String partialName,
      @PageableDefault(
              sort = {"pt_name"},
              value = 10)
          Pageable pageable) {

    Sort sort = pageable.getSort();

    if (sort == null || sort.isEmpty() || sort.toString().contains("string")) {
      sort = Sort.by("pt_name");
    }

    return iPartnerMetricsService.listPartnerMetrics(
        partialName, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
  }

  @GetMapping
  @RequestMapping(value = "/{id}")
  public List<PartnerMetrics> partnerMetricsById(@PathVariable("id") Long id) {
    return iPartnerMetricsService.listPartnerMetricById(id);
  }
}
