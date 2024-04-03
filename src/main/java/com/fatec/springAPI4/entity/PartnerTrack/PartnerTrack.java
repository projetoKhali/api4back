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
public class PartnerExpertise {
    @EmbeddedId
    private PartnerTrackPrimaryData partnerTrackPrimaryData;
    
    @Column(name = pt_tk_insert_date)
    private LocalDate insertDate;   
}
