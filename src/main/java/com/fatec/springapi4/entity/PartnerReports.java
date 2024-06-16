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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partner_reports")
public class PartnerReports {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "pt_id")
    private Long partnerId;

    @Column(name = "pt_name")
    private String partnerName;

    @Column(name = "tk_name")
    private String trackName;

    @Column(name = "tk_start_date")
    private LocalDate trackStartDate;

    @Column(name = "tk_end_date")
    private LocalDate trackEndDate;

    @Column(name = "ex_name")
    private String expertiseName;

    @Column(name = "ex_start_date")
    private LocalDate expertiseStartDate;

    @Column(name = "ex_end_date")
    private LocalDate expertiseEndDate;

    @Column(name = "ql_name")
    private String qualifierName;

    @Column(name = "ql_start_date")
    private LocalDate qualifierStartDate;

    @Column(name = "ql_end_date")
    private LocalDate qualifierEndDate;

    @Column(name = "ql_due_date")
    private LocalDate qualifierDueDate;
}
