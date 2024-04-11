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
import jakarta.persistence.Table;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tk_id")
    private Long id;

    @Column(name = "tk_name")
    private String name;
    
    @Column(name = "tk_complete_date")
    private LocalDate completeDate;

    @Column(name = "tk_association_date")
    private LocalDate associationDate;
}
