package com.fatec.springapi4.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    PartnerRepository partnerRepository;

    @Autowired
    IPartnerService iPartnerService;

    @Autowired
    IPartnerTrackService iPartnerTrackService;

    @Autowired
    IPartnerExpertiseService iPartnerExpertiseService;

    @Autowired
    IPartnerQualifierService iPartnerQualifierService;

    @GetMapping
    public List<Partner> listPartners() {
        return iPartnerService.listPartners();
    }

    @GetMapping(value = "/find/{partner}")
    public Partner findById(@PathVariable("partner") Long id) {
        return iPartnerService.findPartnerById(id);
    }

    @PostMapping
    public Partner saveAndUpdatePartner(@RequestBody Partner partner) {
        return iPartnerService.saveAndUpdatePartner(partner);
    }

    @PatchMapping("/{id}")
    public Partner updatePartnerField(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String fieldName = requestBody.get("fieldName");
        String value = requestBody.get("value");
        return iPartnerService.updatePartnerField(id, fieldName, value);
    }

    @DeleteMapping(value = "/{partnerId}")
    public void deleteById(@PathVariable("partnerId") Long id) {
        iPartnerService.delPartnerById(id);
    }

    @GetMapping("/{partnerId}")
    public ResponseEntity<PartnerSimpleDTO> getPartnerWithDetails(@PathVariable Long partnerId) {
        PartnerSimpleDTO partnerSimpleDTO = iPartnerService.getPartnerWithDetails(partnerId);
        return new ResponseEntity<>(partnerSimpleDTO, HttpStatus.OK);
    }

    @GetMapping("/{partnerId}/tracks")
    public List<PartnerTrackDTO> getAllPartnerTrackWithDetails(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return iPartnerService.getAllPartnerTrackWithDetails(partner);
    }

    @GetMapping("/{partnerId}/expertises")
    public List<PartnerExpertiseDTO> getAllPartnerExpertise(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return iPartnerService.getAllPartnerExpertise(partner);
    }

    @GetMapping("/{partnerId}/qualifiers")
    public List<PartnerQualifierDTO> getAllPartnerQualifier(@PathVariable Long partnerId) {
        Partner partner = new Partner();
        partner.setId(partnerId);
        return iPartnerService.getAllPartnerQualifier(partner);
    }

    // ASSOCIAÇÕES PARTNER

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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao associar parceiro com expertise.");
        }
    }

    @PostMapping("/associatePartnerQualifier")
    public ResponseEntity<String> associatePartnerWithQualifier(@RequestBody PartnerQualifierAssociateDTO dto) {
        try {
            iPartnerQualifierService.associatePartnerWithQualifier(dto);
            ;
            return ResponseEntity.ok("Associação de parceiro com qualifier realizada com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao associar parceiro com qualifier.");
        }
    }

}
