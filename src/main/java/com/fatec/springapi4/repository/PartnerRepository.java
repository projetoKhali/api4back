package com.fatec.springapi4.repository;

import com.fatec.springapi4.entity.Partner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Optional<Partner> findById(Long id);

    Optional<Partner> findByName(String name);
}
