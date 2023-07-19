package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.dto.ResponsePreguntasDto;
import com.aduni.exams.usuarios.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Integer> {

    @Query(value = "SELECT p.* FROM preguntas p " +
            "INNER JOIN alternativas a ON p.id = a.pregunta_id " +
            "WHERE p.curso_id = :cursoId " +
            "ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Pregunta> findRandomPreguntasWithAlternativasByCursoId(Integer cursoId);


}