package com.aduni.exams.usuarios.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String codigo;
    private String password;
    @Column(columnDefinition = "CHAR(1) default 'A'")
    private Character estado;
    @Column(columnDefinition = "CHAR(1) default 'E'")
    private Character rol;


}
