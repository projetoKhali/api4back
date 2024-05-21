package com.fatec.springapi4.entity;


import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="partner_metrics")
public class PartnerMetrics {
    
    @Id
    @Column(name = "pt_id")
    private Long pt_id;

    @Column(name = "pt_name")
    private String pt_name;

    @Column(name = "pt_city")
    private String pt_city;

    @Column(name = "tracks")
    private BigInteger tracks;

    @Column(name = "completed_tracks")
    private BigInteger completed_tracks;

    @Column(name = "qualifiers")
    private BigInteger qualifiers;

    @Column(name = "completed_qualifiers")
    private BigInteger completed_qualifiers;
    
}
