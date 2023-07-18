package com.aduni.exams.usuarios.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer usuario_id;
    private Double nota;
    private Character apreciacion;
    private Date fecha_realizada;
    private Time tiempo;
    private String curso;

}
