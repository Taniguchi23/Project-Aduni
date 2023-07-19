package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {
    @Query("SELECT s FROM Skill s WHERE s.usuario_id = ?1")
    Skill findFirstByUsuarioId(Integer usuarioId);
}
