package com.aduni.exams.usuarios.dto;

import com.aduni.exams.usuarios.entity.Usuario;
import lombok.Data;
    @Data
    public class ResponseLoginDto {
        private  String estado;
        private  String mensaje;
        private Usuario usuario;
    }
