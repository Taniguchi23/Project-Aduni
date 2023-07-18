package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.dto.ResponseLoginDto;
import com.aduni.exams.usuarios.entity.Usuario;
import com.aduni.exams.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UsuarioRepository repo;
    //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public ResponseLoginDto login(String codigo, String password) {
        List<Usuario> usuario = repo.findUserByCodigo(codigo);
        ResponseLoginDto responseLogin = new ResponseLoginDto();
        if (usuario.size()>0){
            boolean response =  usuario.get(0).getPassword().equals(password);
            if (response){
                if (usuario.get(0).getEstado().equals("I")){
                    responseLogin.setEstado("error");
                    responseLogin.setMensaje("Usuario inactivo");
                }else {
                    responseLogin.setEstado("ok");
                    responseLogin.setMensaje("Usuario valido");
                    responseLogin.setUsuario(usuario.get(0));
                }
            }else {
                responseLogin.setEstado("error");
                responseLogin.setMensaje("Credenciales incorrectas");
            }
        }else {
            responseLogin.setEstado("error");
            responseLogin.setMensaje("Usuario no encontrado");
        }

        return responseLogin;
    }
}
