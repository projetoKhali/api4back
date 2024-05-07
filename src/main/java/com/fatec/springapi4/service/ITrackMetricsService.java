package com.fatec.springapi4.service;

import java.util.List;
import com.fatec.springapi4.entity.TrackMetrics;

public interface ITrackMetricsService {
    public List<TrackMetrics> listTrackMetrics();
    public List<TrackMetrics> listTrackMetricsByTrackId(Long id);
}
