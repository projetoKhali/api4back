package com.fatec.springapi4.repository;

import com.fatec.springapi4.entity.PartnerMetrics;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMetricsRepository extends JpaRepository<PartnerMetrics, Long> {

    Optional<PartnerMetrics> findById(@Param("id") Long id);

    @Query("select p from PartnerMetrics p where"
            + " :partialName is null or :partialName = '' or"
            + " p.name like %:partialName%")
    Page<PartnerMetrics> findByPartialName(String partialName, Pageable pageable);
}
