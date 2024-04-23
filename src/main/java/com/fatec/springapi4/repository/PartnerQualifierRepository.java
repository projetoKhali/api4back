package com.fatec.springapi4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Partner;
import com.fatec.springapi4.entity.PartnerQualifier;
import com.fatec.springapi4.entity.Qualifier;

@Repository
public interface PartnerQualifierRepository extends JpaRepository<PartnerQualifier, Long> {
    List<PartnerQualifier> findByPartner(Partner partner);

    Optional<PartnerQualifier> findByQualifierAndPartner(Qualifier qualifier, Partner partner);
    
}
