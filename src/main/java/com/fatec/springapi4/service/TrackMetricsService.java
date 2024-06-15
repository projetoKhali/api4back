package com.fatec.springapi4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.TrackMetrics;
import com.fatec.springapi4.repository.TrackMetricsRepository;

@Service
public class TrackMetricsService implements ITrackMetricsService {

    @Autowired
    private TrackMetricsRepository trackMetricsRepository;

    public List<TrackMetrics> listTrackMetrics() {
        return trackMetricsRepository.findAll();
    }

    public List<TrackMetrics> listTrackMetricsByTrackId(Long id) {
        return trackMetricsRepository.findByTrackId(id);
    }

}
