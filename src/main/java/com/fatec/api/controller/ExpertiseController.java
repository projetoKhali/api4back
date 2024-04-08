package com.fatec.api.controller;

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

import com.fatec.api.entity.Expertise;
import com.fatec.api.service.IExpertiseService;

@RestController
@CrossOrigin
@RequestMapping(value = "/expertise")
public class ExpertiseController {

    @Autowired
    private IExpertiseService expServ;

    @GetMapping(value = "/{expertise}")
    public Expertise findById(@PathVariable("expertise") Long id) {
        return expServ.findExpertiseById(id);
    }

    @GetMapping
    public List<Expertise> listExpertises() {
        return expServ.listExpertises();
    }

    @PostMapping
    public Expertise saveAndUpdateExpertise(@RequestBody Expertise expertise) {
        return expServ.saveAndUpdateExpertise(expertise);
    }

    @DeleteMapping(value = "/{expertiseId}")
    public void deleteById(@PathVariable("expertiseId") Long id) {
        expServ.delExpertiseById(id);
    }
    
}
