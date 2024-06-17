package com.fatec.springapi4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.TrackMetrics;
import com.fatec.springapi4.service.ITrackMetricsService;

@RestController
@CrossOrigin
@RequestMapping(value = "/trackmetrics")
public class TrackMetricsController {

    @Autowired
    private ITrackMetricsService trackMetricsService;

    @GetMapping
    public List<TrackMetrics> getTrackMetrics() {
        return trackMetricsService.listTrackMetrics();
    }

    @GetMapping(value = "/{trackId}")
    public List<TrackMetrics> getTrackMetricsByTrackId(@PathVariable("trackId") Long id) {
        return trackMetricsService.listTrackMetricsByTrackId(id);
    }

}
