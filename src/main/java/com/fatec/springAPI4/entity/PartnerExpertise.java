package com.fatec.springApi4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
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

@Getter @Setter @AllArgsConstructor
@Entity
@Table(name = "Partner_Expertise", uniqueConstraints = { @UniqueConstraint(columnNames = { "pt_id", "ex_id" }) })
public class PartnerExpertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_ex_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
    private Partner partnerId;
    
    @ManyToOne
    @JoinColumn(name = "ex_id", referencedColumnName = "ex_id")
    private Expertise expertiseId;
    
    @Column(name = "pt_ex_insert_date")
    private LocalDate insertDate;   
    
    @Column(name = "pt_ex_complete_date")
    private LocalDate completeDate;   
}
