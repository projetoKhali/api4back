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

import com.fatec.api.entity.Qualifier;
import com.fatec.api.service.IQualifierService;

@RestController
@CrossOrigin
@RequestMapping(value = "/qualifier")
public class QualifierController {

    @Autowired
    private IQualifierService qlfServ;

    @GetMapping(value = "/{qualifier}")
    public Qualifier findById(@PathVariable("qualifier") Long id) {
        return qlfServ.findQualifierById(id);
    }

    @GetMapping
    public List<Qualifier> listQualifiers() {
        return qlfServ.listQualifiers();
    }

    @PostMapping
    public Qualifier saveAndUpdateQualifier(@RequestBody Qualifier qlf) {
        return qlfServ.saveAndUpdateQualifier(qlf);
    }

    @DeleteMapping(value = "/{qualifierId}")
    public void deleteById(@PathVariable("trackId") Long id) {
        qlfServ.delQualifierkById(id);
    }
    
}
