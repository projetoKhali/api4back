package com.fatec.springapi4.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.PartnerReports;
import com.fatec.springapi4.repository.PartnerReportsRepository;
import com.fatec.springapi4.service.IPartnerReportsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping(value = "/partnerReports")
public class PartnerReportsController {

    @Autowired
    private IPartnerReportsService iPartnerReportsService;

    @Autowired
    private PartnerReportsRepository partnerReportsRepository;

    @GetMapping
    public Page<PartnerReports> allPartnerReports(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return partnerReportsRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public List<PartnerReports> partnerReportsById(@PathVariable("id") Long id) {
        return iPartnerReportsService.listPartnerReportsById(id);
    }

}
