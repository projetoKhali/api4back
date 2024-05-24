package com.fatec.springapi4.repository;

import com.fatec.springapi4.entity.PartnerMetrics;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMetricsRepository extends JpaRepository<PartnerMetrics, Long> {

  @Query("select p from PartnerMetrics p where p.pt_id = :id")
  List<PartnerMetrics> findByPartnerId(@Param("id") Long id);

  @Query(
      "select p from PartnerMetrics p where"
          + " :partialName is null or :partialName = '' or"
          + " p.pt_name like %:partialName%")
  Page<PartnerMetrics> findByPartialName(String partialName, Pageable pageable);
}
