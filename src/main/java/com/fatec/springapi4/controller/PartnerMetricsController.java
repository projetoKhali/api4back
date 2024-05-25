package com.fatec.springapi4.controller;

import com.fatec.springapi4.entity.PartnerMetrics;
import com.fatec.springapi4.schema.PartnerMetricsRequest;
import com.fatec.springapi4.service.IPartnerMetricsService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/partnerMetrics")
public class PartnerMetricsController {

    @Autowired
    private IPartnerMetricsService iPartnerMetricsService;

    @PostMapping
    public Page<PartnerMetrics> allPartnerMetrics(
            @RequestBody PartnerMetricsRequest body,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name") String sortField) {

        Sort sort = Sort.by(sortField);

        if (sort == null || sort.isEmpty() || sort.toString().contains("string")) {
            sort = Sort.by("name");
        }

        return iPartnerMetricsService.listPartnerMetrics(
                body.getPartialName(), PageRequest.of(page > 0 ? page : 0, size > 0 ? size : 10, sort));
    }

    @GetMapping(value = "/{id}")
    public Optional<PartnerMetrics> partnerMetricsById(@PathVariable("id") Long id) {
        return iPartnerMetricsService.listPartnerMetricById(id);
    }
}
