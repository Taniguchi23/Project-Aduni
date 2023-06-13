package com.aduni.exams.universidades.repository;

import com.aduni.exams.universidades.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {
    @Query("SELECT u FROM Universidad u  ORDER BY u.id DESC ")
    List<Universidad> findUniversidadAll();
}
