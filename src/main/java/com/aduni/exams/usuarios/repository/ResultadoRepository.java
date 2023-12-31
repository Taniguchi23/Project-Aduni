package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
    @Query("SELECT r FROM Resultado r  WHERE r.usuario_id = :id  ORDER BY r.id DESC ")
    List<Resultado> findResultado(@Param("id") int id);

    @Query("SELECT r FROM Resultado r WHERE r.curso = :cadena and r.usuario_id = :idUsuario ORDER BY r.id DESC")
    List<Resultado> findUltimosResultadosPorCadena(String cadena, Integer idUsuario);
}
