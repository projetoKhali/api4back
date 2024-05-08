package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.dto.Product.ProductExpertiseDTO;
import com.fatec.springapi4.dto.Product.ProductExpertisePartnerDTO;
import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.Track;

public interface IExpertiseService {
    
    public Expertise findExpertiseById(Long id);

    public List<Expertise> listExpertises();
    
    public Expertise saveAndUpdateExpertise(Expertise expertise);

    public void delExpertiseById (Long id);

    public List<ProductExpertiseDTO> findExpertisesDTOByTrackId(Long trackId);

    public List<ProductExpertisePartnerDTO> findExpertisesDTOByPartnerAndTrack (Track track, Partner partner);
}
