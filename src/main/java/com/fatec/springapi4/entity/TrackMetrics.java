package com.fatec.springapi4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "track_metrics")
public class TrackMetrics {
    @Id
    @Column(name = "tk_id")
    private Long tkId;

    @Column(name = "tk_name")
    private String tkName;

    @Column(name = "expertise_count")
    private Long expertiseCount;

    @Column(name = "qualifier_count")
    private Long qualifierCount;

    @Column(name = "partner_count")
    private Long partnerCount;

    @Column(name = "avg_expertise_completion_time")
    private Double avgExpertiseCompletionTime;

    @Column(name = "avg_qualifier_completion_time")
    private Double avgQualifierCompletionTime;

    @Column(name = "avg_qualifier_completion_percentage")
    private Double avgQualifierCompletionPercentage;

    @Column(name = "avg_expertise_completion_percentage")
    private Double avgExpertiseCompletionPercentage;

    @Column(name = "avg_expired_qualifiers")
    private Double avgExpiredQualifiers;

    @Column(name = "track_completion_percentage")
    private Double avgTrackCompletionPercentage;

    @Column(name = "avg_track_completion_time")
    private Double avgTrackCompletionTime;
}
