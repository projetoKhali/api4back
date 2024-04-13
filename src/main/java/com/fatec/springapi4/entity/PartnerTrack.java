package com.fatec.springapi4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Partner_Track", uniqueConstraints = { @UniqueConstraint(columnNames = { "pt_id", "tk_id" }) })
public class PartnerTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_tk_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
    private Partner partner;
    
    @ManyToOne
    @JoinColumn(name = "tk_id", referencedColumnName = "tk_id")
    private Track track;
    
    @Column(name = "pt_tk_insert_date")
    private LocalDate insertDate;   
    
    @Column(name = "pt_tk_complete_date")
    private LocalDate completeDate;   
}
