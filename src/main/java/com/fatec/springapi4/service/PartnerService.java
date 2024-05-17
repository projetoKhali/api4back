package com.fatec.springapi4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.dto.DetailsPartner.PartnerExpertiseDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerQualifierDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerSimpleDTO;
import com.fatec.springapi4.dto.DetailsPartner.PartnerTrackDTO;
import com.fatec.springapi4.dto.DetailsPartner.TrackExpertiseProgressDTO;
import com.fatec.springapi4.dto.DetailsPartner.TrackProgressDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.dto.Product.ProductPartnerDTO;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.PartnerTrack;
import com.fatec.springapi4.entity.Qualifier;
import com.fatec.springapi4.entity.Track;
import com.fatec.springapi4.repository.ExpertiseQualifierRepository;
import com.fatec.springapi4.repository.ExpertiseRepository;
import com.fatec.springapi4.repository.PartnerExpertiseRepository;
import com.fatec.springapi4.repository.PartnerQualifierRepository;
import com.fatec.springapi4.repository.PartnerRepository;
import com.fatec.springapi4.repository.PartnerTrackRepository;
import com.fatec.springapi4.repository.QualifierRepository;
import com.fatec.springapi4.repository.TrackRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


@Service
public class PartnerService implements IPartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    ExpertiseRepository expertiseRepository;

    @Autowired
    QualifierRepository qualifierRepository;

    @Autowired
    ExpertiseQualifierRepository expertiseQualifierRepository;

    @Autowired
    PartnerTrackRepository partnerTrackRepository;

    @Autowired
    PartnerExpertiseRepository partnerExpertiseRepository;

    @Autowired
    PartnerQualifierRepository partnerQualifierRepository;

    @Autowired
    ExpertiseService expertiseService;
    
    @Autowired
    QualifierService qualifierService;


    public Partner findPartnerById(Long id) {
        Optional<Partner> partnerOptional = partnerRepository.findById(id);
        if (partnerOptional.isPresent()) {
            return partnerOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Partner findPartnerByName(String name) {
        Optional<Partner> partnerOptional = partnerRepository.findByName(name);
        if (partnerOptional.isPresent()) {
            return partnerOptional.get();
        }
        throw new IllegalArgumentException("Nome inválido!");
    }

    public Page<Partner> listPartners(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return partnerRepository.findAll(pageable);
    }

    public Partner saveAndUpdatePartner(Partner partner) {
        if (partner == null ||
                partner.getName() == null) {
            throw new IllegalArgumentException("Error!");
        }
        return partnerRepository.save(partner);
    }

    @Override
    public Partner updatePartnerField(Long id, String fieldName, String value) {
        Partner existingPartner = partnerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partner not found with id: " + id));

        BeanWrapper wrapper = new BeanWrapperImpl(existingPartner);
        wrapper.setPropertyValue(fieldName, value);

        return partnerRepository.save(existingPartner);
    }

    public void delPartnerById(Long id) {
        partnerRepository.deleteById(id);
    }

    public Partner updatePartner(Long id, Map<String, Object> fields) {
        
        Partner partner = partnerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Entity not found: " + id));

            fields.forEach((field, value) ->{
                switch (field) {
                    case "name":
                        partner.setName((String) value);
                        break;
                    case "companyId":
                        partner.setCompanyId((String) value);
                        break;
                    case "adminName":
                        partner.setAdminName((String) value);
                        break;
                    case "adminEmail":
                        partner.setAdminEmail((String) value);
                        break;
                    case "slogan":
                        partner.setSlogan((String) value);
                        break;
                    case "country":
                        partner.setCountry((String) value);
                        break;
                    case "city":
                        partner.setCity((String) value);
                        break;
                    case "address":
                        partner.setAddress((String) value);
                        break;
                    case "compliance":
                        partner.setCompliance((Boolean) value);
                        break;
                    case "credit":
                        partner.setCredit((Boolean) value);
                        break;
                    case "status":
                        partner.setStatus((Boolean) value);
                        break;
                    case "memberType":
                        partner.setMemberType((Boolean) value);
                        break;
                    default:
                        System.out.println("Undeffinid field: " + field);
                        break;
                }
            });

        return partnerRepository.save(partner);
    }

    public PartnerSimpleDTO getPartnerWithDetails(Long partnerId) {
        Optional<Partner> partnerOptional = partnerRepository.findById(partnerId);

        if (partnerOptional.isPresent()) {
            Partner partner = partnerOptional.get();

            PartnerSimpleDTO partnerSimpleDTO = new PartnerSimpleDTO();
            partnerSimpleDTO.setName(partner.getName());
            partnerSimpleDTO.setLocation(partner.getCity());

            List<PartnerTrackDTO> partnerTrackDTOs = getAllPartnerTrackWithDetails(partner);

            partnerSimpleDTO.setTracks(partnerTrackDTOs);

            return partnerSimpleDTO;
        } else {
            throw new IllegalArgumentException("Id de parceiro inválido!");
        }
    }

    public List<PartnerTrackDTO> getAllPartnerTrackWithDetails(Partner partner) {

        List<PartnerTrack> partnerTracks = partnerTrackRepository.findByPartner(partner);
        List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartner(partner);

        List<PartnerTrackDTO> partnerTrackDTOs = new ArrayList<>();

        for (PartnerTrack partnerTrack : partnerTracks) {
            PartnerTrackDTO partnerTrackDTO = new PartnerTrackDTO();

            partnerTrackDTO.setName(partnerTrack.getTrack().getName());
            partnerTrackDTO.setInsertDate(partnerTrack.getInsertDate());
            partnerTrackDTO.setCompleteDate(partnerTrack.getCompleteDate());

            List<PartnerExpertiseDTO> partnerExpertiseByTrackDTO = new ArrayList<>();

            for (PartnerExpertise partnerExpertise : partnerExpertises) {
                Expertise expertise = partnerExpertise.getExpertise();

                if (expertise.getTrack().getName().equals(partnerTrackDTO.getName())) {
                    PartnerExpertiseDTO partnerExpertiseDTO = new PartnerExpertiseDTO();

                    partnerExpertiseDTO.setName(partnerExpertise.getExpertise().getName());
                    partnerExpertiseDTO.setInsertDate(partnerExpertise.getInsertDate());
                    partnerExpertiseDTO.setCompleteDate(partnerExpertise.getCompleteDate());

                    List<PartnerQualifier> partnerQualifiers = partnerQualifierRepository.findByPartner(partner);
                    List<PartnerQualifierDTO> partnerQualifierByExpertiseDTOs = new ArrayList<>();

                    for (PartnerQualifier partnerQualifier : partnerQualifiers) {
                        Qualifier qualifier = partnerQualifier.getQualifier();

                        boolean isRelated = expertiseQualifierRepository.existsByExpertiseIdAndQualifierId(expertise, qualifier);

                        if (isRelated) {
                            PartnerQualifierDTO partnerQualifierDTO = new PartnerQualifierDTO();

                            partnerQualifierDTO.setName(partnerQualifier.getQualifier().getName());
                            partnerQualifierDTO.setInsertDate(partnerQualifier.getInsertDate());
                            partnerQualifierDTO.setCompleteDate(partnerQualifier.getCompleteDate());

                            partnerQualifierByExpertiseDTOs.add(partnerQualifierDTO);
                            
                        }

                        
                    }

                    partnerExpertiseDTO.setQualifiers(partnerQualifierByExpertiseDTOs);
                    partnerExpertiseByTrackDTO.add(partnerExpertiseDTO);
                }
            
            }
            
            partnerTrackDTO.setExpertises(partnerExpertiseByTrackDTO);
            partnerTrackDTOs.add(partnerTrackDTO);
        
        }
        
        return partnerTrackDTOs;
    
    }

    public List<TrackExpertiseProgressDTO> getTrackExpertiseProgress() {
        List<Partner> partners = partnerRepository.findAll();

        return partners.stream().map(partner -> {
            TrackExpertiseProgressDTO trackExpertiseProgressDTO = new TrackExpertiseProgressDTO();
            trackExpertiseProgressDTO.setPartner(partner.getName());
            trackExpertiseProgressDTO.setLocation(partner.getCity());

            List<PartnerTrack> partnerTracks = partnerTrackRepository.findByPartner(partner);

            List<TrackProgressDTO> trackProgressDTOS = partnerTracks.stream().map(partnerTrack -> {
                Track track = partnerTrack.getTrack();

                List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartner(partner);

                long totalExpertises = 0; //onde buscar(associação trackexpertise)????
                long associatedExpertise = partnerExpertises.stream()
                .filter(pe -> pe.getExpertise().getTrack().getId().equals(track.getId()))
                .count();
                long completedExpertises = partnerExpertises.stream()
                .filter(pe -> pe.getExpertise().getTrack().getId().equals(track.getId()) && pe.getCompleteDate() != null)
                .count();

                TrackProgressDTO trackProgressDTO = new TrackProgressDTO();
                trackProgressDTO.setTrackName(track.getName());
                trackProgressDTO.setExpertisesTrack(totalExpertises);
                trackProgressDTO.setProgressExpertises(associatedExpertise);
                trackProgressDTO.setFinalizedExpertises(completedExpertises);
                
                return trackProgressDTO;
            }).collect(Collectors.toList());

            trackExpertiseProgressDTO.setTracks(trackProgressDTOS);

            return trackExpertiseProgressDTO;
        }).collect(Collectors.toList());

}

    public List<PartnerExpertiseDTO> getAllPartnerExpertise(Partner partner) {
        List<PartnerExpertise> partnerExpertises = partnerExpertiseRepository.findByPartner(partner);
        List<PartnerExpertiseDTO> partnerExpertiseDTOs = new ArrayList<>();

        for (PartnerExpertise partnerExpertise : partnerExpertises) {
            PartnerExpertiseDTO partnerExpertiseDTO = new PartnerExpertiseDTO();

            partnerExpertiseDTO.setName(partnerExpertise.getExpertise().getName());

            partnerExpertiseDTOs.add(partnerExpertiseDTO);
        }

        return partnerExpertiseDTOs;
    }

    public List<PartnerQualifierDTO> getAllPartnerQualifier(Partner partner) {
        List<PartnerQualifier> partnerQualifiers = partnerQualifierRepository.findByPartner(partner);
        List<PartnerQualifierDTO> partnerQualifierDTOs = new ArrayList<>();

        for (PartnerQualifier partnerQualifier : partnerQualifiers) {
            PartnerQualifierDTO partnerQualifierDTO = new PartnerQualifierDTO();

            partnerQualifierDTO.setName(partnerQualifier.getQualifier().getName());

            partnerQualifierDTOs.add(partnerQualifierDTO);
        }

        return partnerQualifierDTOs;

    }


    public List<ProductPartnerDTO> findPartnersByTrack (Long trackId) {
        Optional<Track> track = trackRepository.findById(trackId);
        List<ProductPartnerDTO> partnersDTO = new ArrayList<ProductPartnerDTO>();
        if(track.isEmpty()) {return partnersDTO;}
        List<PartnerTrack> partnersTracks = partnerTrackRepository.findByTrack(track.get());
        if (track.isEmpty()) {return partnersDTO;}
        for (PartnerTrack partnerTrack : partnersTracks) {
            Optional<Partner> partnerOptional = partnerRepository.findById(partnerTrack.getId());
            if (partnerOptional.isEmpty()) {continue;}
            ProductPartnerDTO partnerDTO = 
                new ProductPartnerDTO(
                    partnerOptional.get(), 
                    partnerTrack, 
                    expertiseService.findExpertisesDTOByPartnerAndTrack (track.get(), partnerOptional.get()),
                    qualifierService.findQualifiersDTOByPartnerAndTrack (track.get(), partnerOptional.get()));
            partnersDTO.add(partnerDTO);
        }
        return partnersDTO;
    }

    public Page<Partner> filterPartner(String country,Boolean compliance,Boolean credit, Boolean status,
                                       Boolean memberType, Pageable pageable){
            Partner p = new Partner();
            p.setCountry(country);
            p.setCompliance(compliance);
            p.setCredit(credit);
            p.setStatus(status);
            p.setMemberType(memberType);

            return partnerRepository.findAll(Example.of(p), pageable);

    }
}
