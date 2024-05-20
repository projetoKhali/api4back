package com.fatec.springapi4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ExpertiseQualifier", uniqueConstraints = { @UniqueConstraint(columnNames = { "ex_id", "ql_id" }) })
public class ExpertiseQualifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ex_ql_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ex_id", referencedColumnName = "ex_id")
    private Expertise expertiseId;
    
    @ManyToOne
    @JoinColumn(name = "ql_id", referencedColumnName = "ql_id")
    private Qualifier qualifierId;

}
