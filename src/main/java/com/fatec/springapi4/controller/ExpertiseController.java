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

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.service.IExpertiseService;

@RestController
@CrossOrigin
@RequestMapping(value = "/expertise")
public class ExpertiseController {

    @Autowired
    private IExpertiseService exppertiseServeService;

    @GetMapping(value = "/{expertise}")
    public Expertise findById(@PathVariable("expertise") Long id) {
        return exppertiseServeService.findExpertiseById(id);
    }

    @GetMapping
    public List<Expertise> listExpertises() {
        return exppertiseServeService.listExpertises();
    }

    @PostMapping
    public Expertise saveAndUpdateExpertise(@RequestBody Expertise expertise) {
        return exppertiseServeService.saveAndUpdateExpertise(expertise);
    }

    @DeleteMapping(value = "/{expertiseId}")
    public void deleteById(@PathVariable("expertiseId") Long id) {
        exppertiseServeService.delExpertiseById(id);
    }
    
}
