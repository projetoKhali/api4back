package main.java.com.fatec.springAPI4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor
@Entity
@Table
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_id")
    private Long id;

    @Column(unique = true, name = "pt_company_id")
    private String companyId;
    
    @Column(name = "pt_name")
    private String name;

    @Column(name = "pt_admin_name")
    private String adminName;

    @Column(name = "pt_admin_email")
    private String adminEmail;

    @Column(name = "pt_compliance")
    private Boolean compliance;

    @Column(name = "pt_credit")
    private Boolean credit;

    @Column(name = "pt_status")
    private Boolean status;

    @Column(name = "pt_membership")
    private LocalDate membership;

    @Column(name = "pt_slogan")
    private String slogan;

    @Column(name = "pt_country")
    private String country;

    @Column(name = "pt_city")
    private String city;

    @Column(name = "pt_number")
    private String number;

    @Column(name = "pt_address")
    private String address;
}
