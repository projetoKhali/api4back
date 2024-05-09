package com.fatec.springapi4.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fatec.springapi4.converter.ProfileTypeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_login")
    private String login;
    
    @Column(name = "usr_name")
    private String name;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "usr_password", insertable = true, updatable = true)
    private String password;

    @Convert(converter = ProfileTypeConverter.class)
    @Column(name = "usr_profile_type")
    private ProfileType profileType;

}
