package com.fatec.springapi4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.service.IPartnerService;

@RestController
@CrossOrigin
@RequestMapping(value = "/partner")
public class PartnerController {
    
    @Autowired
    private IPartnerService partnerService;

    @GetMapping(value = "/{partner}")
    public Partner findById(@PathVariable("partner") Long id) {
        return partnerService.findPartnerById(id);
    }

    @GetMapping
    public List<Partner> listPartners() {
        return partnerService.listPartners();
    }

    @PostMapping
    public Partner saveAndUpdatePartner(@RequestBody Partner partner) {
        return partnerService.saveAndUpdatePartner(partner);
    }

    @DeleteMapping(value = "/{partnerId}")
    public void deleteById(@PathVariable("partnerId") Long id) {
        partnerService.delPartnerById(id);
    }
}