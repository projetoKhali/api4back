package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.PartnerReports;

@Repository
public interface PartnerReportsRepository extends JpaRepository<PartnerReports, Long> {

    @Query("select p from PartnerReports p order by p.id")
    Page<PartnerReports> findAll(Pageable pageable);

    @Query("select p from PartnerReports p where p.id = :id")
    List<PartnerReports> findByPartnerId(@Param("id") Long id);

}
