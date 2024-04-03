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
public class PartnerQualifier {
    @EmbeddedId
    private PartnerQualifierPrimaryData partnerQualifierPrimaryData;
    
    @Column(name = pt_ql_insert_date)
    private LocalDate insertDate;   
    
    @Column(name = pt_ql_complete_date)
    private LocalDate completeDate;   
}
