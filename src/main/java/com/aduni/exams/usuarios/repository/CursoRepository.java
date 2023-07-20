package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.entity.Curso;
import com.aduni.exams.usuarios.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {
    @Query("SELECT c FROM Curso c WHERE c.id = :id")
    Curso findCursoById(int id);
}
