package main.java.com.fatec.springAPI4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor
@Entity
@Table(name = "Partner_Track", uniqueConstraints = { @UniqueConstraint(columnNames = { "pt_id", "tk_id" }) })
public class PartnerTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pt_tk_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(unique=true, name = "pt_id", referencedColumnName = "pt_id")
    private Partner partnerId;
    
    @ManyToOne
    @JoinColumn(name = "tk_id", referencedColumnName = "tk_id")
    private Track trackId;
    
    @Column(name = "pt_tk_insert_date")
    private LocalDate insertDate;   
}
