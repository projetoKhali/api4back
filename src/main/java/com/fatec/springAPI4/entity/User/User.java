package com.fatec.springApi4.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter @Setter @AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_login")
    private String login;
    
    @Column(name = "usr_name")
    private String name;
    
    @Column(name = "usr_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile_type")
    private ProfileType profileType;
}
