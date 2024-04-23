package com.fatec.springapi4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.dto.ExpertiseQualifierAssociateDTO;
import com.fatec.springapi4.dto.DetailsPartner.ExpertiseQualifierDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.ExpertiseQualifier;
import com.fatec.springapi4.repository.ExpertiseQualifierRepository;
import com.fatec.springapi4.service.ExpertiseQualifierService;
import com.fatec.springapi4.service.IExpertiseQualifier;
import com.fatec.springapi4.service.IExpertiseService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "/expertise")
public class ExpertiseController {

    @Autowired
    IExpertiseService iExpertiseService;

    @Autowired
    IExpertiseQualifier iExpertiseQualifier;

    @Autowired
    ExpertiseQualifierRepository expertiseQualifierRepository;

    @Autowired
    ExpertiseQualifierService expertiseQualifierService;

    @GetMapping(value = "/{expertise}")
    public Expertise findById(@PathVariable("expertise") Long id) {
        return iExpertiseService.findExpertiseById(id);
    }

    @GetMapping
    public List<Expertise> listExpertises() {
        return iExpertiseService.listExpertises();
    }

    @PostMapping
    public Expertise saveAndUpdateExpertise(@RequestBody Expertise expertise) {
        return iExpertiseService.saveAndUpdateExpertise(expertise);
    }

    @DeleteMapping(value = "/{expertiseId}")
    public void deleteById(@PathVariable("expertiseId") Long id) {
        iExpertiseService.delExpertiseById(id);
    }

    @PostMapping("/associateExpertiseQualifier")
    public ResponseEntity<String> associateExpertiseWithQualifier(@RequestBody ExpertiseQualifierAssociateDTO dto) {
        try {
            iExpertiseQualifier.associateExpertiseWithQualifier(dto);
            ;
            return ResponseEntity.ok("Associação de Expertise com Qualifier realizada com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao associar Expertise com Qualifier.");
        }
    }

    @GetMapping("/associate")
    public List<ExpertiseQualifierAssociateDTO> getAllExpertiseQualifierAssociate() {
        return expertiseQualifierService.getAllExpertiseQualifier();
    }

}
