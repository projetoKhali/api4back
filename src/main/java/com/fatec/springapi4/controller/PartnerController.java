package com.fatec.springapi4.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.springapi4.dto.AssociatePartner.PartnerExpertiseAssociateDTO;
import com.fatec.springapi4.dto.AssociatePartner.PartnerQualifierAssociateDTO;
import com.fatec.springapi4.dto.AssociatePartner.PartnerTrackAssociateDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerQualifierDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerSimpleDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerTrackDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.service.IPartnerExpertiseService;
import com.fatec.springapi4.service.IPartnerQualifierService;
import com.fatec.springapi4.service.IPartnerService;
import com.fatec.springapi4.service.IPartnerTrackService;

import jakarta.persistence.EntityNotFoundException;


@RestController
@CrossOrigin
@RequestMapping(value = "/partner")
public class PartnerController {

    @Autowired
    IPartnerService partnerService;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    IPartnerTrackService iPartnerTrackService;

    @Autowired
    IPartnerExpertiseService iPartnerExpertiseService;

    @Autowired
    IPartnerQualifierService iPartnerQualifierService;

    @GetMapping(value = "/find/{partner}")
    public Partner findById(@PathVariable("partner") Long id) {
        return partnerService.findPartnerById(id);
    }

    @GetMapping
    public List<Partner> listPartners() {
        return partnerService.listPartners();
    }

    @GetMapping(value = "/filter")
    public List<Partner> filterPartner(@RequestParam(value = "country", required = false)String country,
                                       @RequestParam(value = "compliance", required = false)Boolean compliance,
                                       @RequestParam(value = "credit", required = false)Boolean credit,
                                       @RequestParam(value = "status", required = false)Boolean status,
                                       @RequestParam(value = "memberType", required = false)Boolean memberType){
        if(country==null&&status==null&&compliance==null&&credit==null&&memberType==null){
            return partnerService.listPartners();
        }else{
            return partnerService.filterPartner(country,compliance,credit, status, memberType);
        }
    }

    @PostMapping(value = "register")
    public Partner saveAndUpdatePartner(@RequestBody Partner partner) {
        return partnerService.saveAndUpdatePartner(partner);
    }

    @DeleteMapping(value = "/{partnerId}")
    public void deleteById(@PathVariable("partnerId") Long id) {
        partnerService.delPartnerById(id);
    }

    @GetMapping("/{partnerId}")
    public ResponseEntity<PartnerSimpleDTO> getPartnerWithDetails(@PathVariable Long partnerId) {
        PartnerSimpleDTO partnerSimpleDTO = partnerService.getPartnerWithDetails(partnerId);
        return new ResponseEntity<>(partnerSimpleDTO, HttpStatus.OK);
    }

    @GetMapping("/{partnerId}/tracks")
    public List<PartnerTrackDTO> getAllPartnerTrackWithDetails(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return partnerService.getAllPartnerTrackWithDetails(partner);
    }

    @GetMapping("/{partnerId}/expertises")
    public List<PartnerExpertiseDTO> getAllPartnerExpertise(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return partnerService.getAllPartnerExpertise(partner);
    }

    @GetMapping("/{partnerId}/qualifiers")
    public List<PartnerQualifierDTO> getAllPartnerQualifier(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return partnerService.getAllPartnerQualifier(partner);
    }



    //ASSOCIAÇÃO

    @PostMapping("/associatePartnerTrack")
    public ResponseEntity<String> associatePartnerWithTrack(@RequestBody PartnerTrackAssociateDTO dto) {
        try {
            iPartnerTrackService.associatePartnerWithTrack(dto);
            return ResponseEntity.ok("Associação de parceiro com track realizada com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao associar parceiro com faixa.");
        }
    }

    @PostMapping("/associatePartnerExpertise")
    public ResponseEntity<String> associatePartnerWithExpertise(@RequestBody PartnerExpertiseAssociateDTO dto) {
        try {
            iPartnerExpertiseService.associatePartnerWithExpertise(dto);
            return ResponseEntity.ok("Associação de parceiro com expertise realizada com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao associar parceiro com expertise.");
        }
    }

    @PostMapping("/associatePartnerQualifier")
    public ResponseEntity<String> associatePartnerWithQualifier(@RequestBody PartnerQualifierAssociateDTO dto) {
        try {
            iPartnerQualifierService.associatePartnerWithQualifier(dto);;
            return ResponseEntity.ok("Associação de parceiro com qualifier realizada com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao associar parceiro com qualifier.");
        }
    }

}


