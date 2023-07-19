package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.entity.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa,Integer> {
    @Query("SELECT a FROM Alternativa a WHERE a.pregunta_id = :preguntaId")
    List<Alternativa> findAlternativasByPreguntaId(@Param("preguntaId") Integer preguntaId);
}
