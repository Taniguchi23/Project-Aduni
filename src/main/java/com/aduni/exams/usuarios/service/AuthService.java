package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.dto.ResponseLoginDto;

public interface AuthService {

    public ResponseLoginDto login(String email, String password) ;
}
