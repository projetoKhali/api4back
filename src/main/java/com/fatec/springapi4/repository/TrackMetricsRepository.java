package com.fatec.springapi4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.TrackMetrics;

@Repository
public interface TrackMetricsRepository extends JpaRepository<TrackMetrics, Long> {

    @Query("select t from TrackMetrics t where t.tkId = :id")
    List<TrackMetrics> findByTrackId(@Param("id") Long tkId);

}
