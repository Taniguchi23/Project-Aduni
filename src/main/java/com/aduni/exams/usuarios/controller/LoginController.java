package com.aduni.exams.usuarios.controller;


import com.aduni.exams.usuarios.dto.ResponseLoginDto;
import com.aduni.exams.usuarios.service.AuthService;
import com.aduni.exams.usuarios.service.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/auth")
@Controller
public class LoginController {

    @Autowired
    private AuthService authService;
    @PostMapping("/login" )
    public String login(@RequestParam("codigo") String codigo, @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpSession session) {
        ResponseLoginDto responseLoginDto =  authService.login(codigo,password);
        if (responseLoginDto.getEstado().equals("ok")){
            session.setAttribute("authId", responseLoginDto.getUsuario().getId());
            session.setAttribute("authNombre", responseLoginDto.getUsuario().getNombres());
            session.setAttribute("authRol", responseLoginDto.getUsuario().getRol());
            session.setAttribute("authEstado", responseLoginDto.getUsuario().getEstado());
            //log.info(""+responseLoginDto.getUsuario().getRol());
            if (responseLoginDto.getUsuario().getRol().equals('E')){
                return "redirect:/home";
            } else{
                return "redirect:/administradores";
            }
        }else {
            redirectAttributes.addFlashAttribute("mensajeError", responseLoginDto.getMensaje());
        }
        return "redirect:/";
    }
}
