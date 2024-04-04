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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "pt_id", "ql_id" }) })
public class PartnerQualifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = pt_ql_id)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
    private Partner partnerId;
    
    @ManyToOne
    @JoinColumn(name = "ql_id", referencedColumnName = "ql_id")
    private Qualifier qualifierId;
    
    @Column(name = pt_ql_insert_date)
    private LocalDate insertDate;   
    
    @Column(name = pt_ql_complete_date)
    private LocalDate completeDate;   
}
