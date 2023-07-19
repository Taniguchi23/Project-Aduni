package com.aduni.exams.usuarios.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "skills")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer usuario_id;
    private Integer historia_peru_a;
    private Integer historia_peru_b;
    private Integer economia_a;
    private Integer economia_b;
    private Integer filosofia_a;
    private Integer filosofia_b;
    private Integer historia_universal_a;
    private Integer historia_universal_b;
    private Integer biologia_a;
    private Integer biologia_b;
    private Integer comunicacion_a;
    private Integer comunicacion_b;
}
