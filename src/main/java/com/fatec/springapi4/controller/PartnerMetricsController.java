package com.fatec.springapi4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.PartnerMetrics;
import com.fatec.springapi4.service.IPartnerMetricsService;


@RestController
@CrossOrigin
@RequestMapping(value = "/partnerMetrics")
public class PartnerMetricsController {
    
    @Autowired
    private IPartnerMetricsService iPartnerMetricsService;

    @GetMapping
    public List<PartnerMetrics> allPartnerMetrics(){
        return iPartnerMetricsService.listPartnerMetrics();
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public List<PartnerMetrics> partnerMetricsById(@PathVariable ("id") Long id){
        return iPartnerMetricsService.listPartnerMetricById(id);
    }
}
