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

import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.service.IQualifierService;

@RestController
@CrossOrigin
@RequestMapping(value = "/qualifier")
public class QualifierController {

    @Autowired
    private IQualifierService qualifierService;

    @GetMapping(value = "/{qualifier}")
    public Qualifier findById(@PathVariable("qualifier") Long id) {
        return qualifierService.findQualifierById(id);
    }

    @GetMapping
    public List<Qualifier> listQualifiers() {
        return qualifierService.listQualifiers();
    }

    @PostMapping
    public Qualifier saveAndUpdateQualifier(@RequestBody Qualifier qualifier) {
        return qualifierService.saveAndUpdateQualifier(qualifier);
    }

    @DeleteMapping(value = "/{qualifierId}")
    public void deleteById(@PathVariable("trackId") Long id) {
        qualifierService.delQualifierkById(id);
    }

}
