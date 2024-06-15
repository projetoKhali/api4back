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
    @Column(name = "pt_id")
    private Long pt_id;

    @Column(name = "pt_name")
    private String pt_name;

    @Column(name = "tk_name")
    private String tk_name;

    @Column(name = "tk_start_date")
    private LocalDate tk_start_date;

    @Column(name = "tk_end_date")
    private LocalDate tk_end_date;

    @Column(name = "ex_name")
    private String ex_name;

    @Column(name = "ex_start_date")
    private LocalDate ex_start_date;

    @Column(name = "ex_end_date")
    private LocalDate ex_end_date;

    @Column(name = "ql_name")
    private String ql_name;

    @Column(name = "ql_start_date")
    private LocalDate ql_start_date;

    @Column(name = "ql_end_date")
    private LocalDate ql_end_date;

    @Column(name = "ql_due_date")
    private LocalDate ql_due_date;
}
