package main.java.com.fatec.springAPI4.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
 
import javax.persistence.Embeddable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class PartnerQualifierId implements Serializable{
    @ManyToOne
    @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
    private Partner partnerId;
    
    @ManyToOne
    @JoinColumn(name = "ql_id", referencedColumnName = "ql_id")
    private Qualifier qualifierId;
}
