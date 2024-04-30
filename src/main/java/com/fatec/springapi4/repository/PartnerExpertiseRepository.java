package com.fatec.springapi4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Expertise;
import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerExpertise;


@Repository
public interface PartnerExpertiseRepository extends JpaRepository<PartnerExpertise, Long>{
    List<PartnerExpertise> findByPartner(Partner partner);

    // testar a seguinte função.
    Optional<PartnerExpertise> findByExpertiseAndPartner(Expertise expertise, Partner partner);
}
