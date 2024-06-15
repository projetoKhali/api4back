package com.fatec.springapi4.repository;

import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.springapi4.entity.Qualifier;

@Repository
public interface QualifierRepository extends JpaRepository<Qualifier, Long> {
    Optional<Qualifier> findByName(String name);

    @Query(value = "SELECT q.ql_id AS ql_id, q.ql_name AS ql_name " +
            "FROM Qualifier q " +
            "JOIN Expertise_Qualifier eq ON q.ql_id = eq.ql_id " +
            "WHERE eq.ex_id = :ex_id", nativeQuery = true)
    public List<Qualifier> getByExpertiseId(@Param("ex_id") Long id);
}
