package com.aduni.exams.repository;

import com.aduni.exams.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
    @Query("SELECT r FROM Resultado r  WHERE r.usuario_id = :id  ORDER BY r.id DESC ")
    List<Resultado> findResultado(@Param("id") int id);
}
