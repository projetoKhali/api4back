package com.fatec.springapi4.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table
public class Partner {
    @Id
    @Column(name = "pt_id")
    private Long id;
    
    @Column(name = "pt_name")
    private String name;

    @Column(name = "pt_admin_name")
    private String adminName;

    @Column(name = "pt_admin_email")
    private String adminEmail;

    @Column(name = "pt_slogan")
    private String slogan;

    @Column(name = "pt_country")
    private String country;

    @Column(name = "pt_city")
    private String city;

    @Column(name = "pt_address")
    private String address;

    @Column(name = "pt_compliance")
    private Boolean compliance;

    @Column(name = "pt_credit")
    private Boolean credit;

    @Column(name = "pt_status")
    private Boolean status;

    @Column(name = "pt_member_type")
    private Boolean memberType;

    @Column(name = "pt_first_date_membership")
    private LocalDate membership;   
}