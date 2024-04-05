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
public class Qualifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ql_id")
    private Long id;

    @Column(name = "ql_name")
    private String name;
}
