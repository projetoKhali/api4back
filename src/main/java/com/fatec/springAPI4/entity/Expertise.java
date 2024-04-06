package com.fatec.springApi4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter @Setter @AllArgsConstructor
@Entity
@Table
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ex_id")
    private Long id;

    @Column(name = "ex_name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "tk_id")
    private Track track;

    @Column(name = "ex_qualifiers")
    private Set<Qualifier> qualifiers;
}
