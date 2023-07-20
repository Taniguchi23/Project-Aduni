package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.entity.*;
import com.aduni.exams.usuarios.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ResultadoServiceImpl implements ResultadoService{
    @Autowired
    private ResultadoRepository resultadoRepository;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private PreguntaService preguntaService;
    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Resultado> listaResultados(int Id) {
        return resultadoRepository.findResultado(Id);
    }

    @Override
    public Resultado entregarNota(Map<String, String> allParams) {
        HttpSession session = request.getSession();
        //Integer authId = (Integer) session.getAttribute("authId");
        //Usuario usuario = usuarioRepository.getById(authId);
         Usuario usuario = usuarioRepository.getById(1);

        Double nota=0.0;
        String id= "";
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            String preguntaId = entry.getKey().split("_")[1];
            String respuestaSeleccionada = entry.getValue();
            if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                nota++;
            }
            id=preguntaId;
        }
        Resultado resultado = new Resultado();
        resultado.setUsuario_id(usuario.getId());
        resultado.setNota(nota);
        resultado.setApreciacion('5');
        Calendar cal = Calendar.getInstance();
        Date fechaActual = cal.getTime();
        long milisegundosDesdeMedianoche = (58 * 60 * 1000) % (24 * 60 * 60 * 1000);
        Time horaHardcodeada = new Time(milisegundosDesdeMedianoche);
        resultado.setFecha_realizada(fechaActual);
        resultado.setTiempo(horaHardcodeada);
        Pregunta pregunta = preguntaRepository.findPreguntaById(Integer.parseInt(id));
        Curso curso = cursoRepository.findCursoById(pregunta.getId());

        resultado.setCurso(curso.getNombre());

        return  resultadoRepository.save(resultado);
    }


}
