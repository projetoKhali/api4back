package com.fatec.springapi4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
