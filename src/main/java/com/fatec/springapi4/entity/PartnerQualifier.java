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

@Entity
@Table(name = "Parter_Qualifier", uniqueConstraints = { @UniqueConstraint(columnNames = { "pt_id", "ql_id" }) })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerQualifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_ql_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
    private Partner partnerId;
    
    @ManyToOne
    @JoinColumn(name = "ql_id", referencedColumnName = "ql_id")
    private Qualifier qualifierId;
    
    @Column(name = "pt_ql_insert_date")
    private LocalDate insertDate;   
    
    @Column(name = "pt_ql_complete_date")
    private LocalDate completeDate;   
}