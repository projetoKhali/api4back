package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.PartnerMetrics;

@Repository
public interface PartnerMetricsRepository extends JpaRepository<PartnerMetrics, Long>{
     
    @Query("select p from PartnerMetrics p where p.pt_id = :id")
    List<PartnerMetrics> findByPartnerId(@Param("id") Long id);
}
