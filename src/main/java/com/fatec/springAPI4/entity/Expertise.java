package main.java.com.fatec.springAPI4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter @Setter @AllArgsConstructor
@Entity
@Table
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ex_id)
    private Long id;

    @Column(name = ex_name)
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tk_id")
    private Track track;

    @Column(name = "ex_qualifiers")
    private List<Qualifier> qualifiers;
}
