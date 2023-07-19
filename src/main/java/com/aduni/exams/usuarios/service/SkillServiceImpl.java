package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.entity.Skill;
import com.aduni.exams.usuarios.entity.Usuario;
import com.aduni.exams.usuarios.repository.SkillRepository;
import com.aduni.exams.usuarios.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PreguntaService preguntaService;

    @Override
    public Skill entregarNota(Map<String, String> allParams) {

        HttpSession session = request.getSession();
        Integer authId = (Integer) session.getAttribute("authId");
        Usuario usuario = usuarioRepository.getById(authId);
       // Usuario usuario = usuarioRepository.getById(1);
        Skill skill= skillRepository.findFirstByUsuarioId(usuario.getId());


        var index= 0;
        var historia_peru= 0;
        var economia= 0;
        var filosofia= 0;
        var historia_universal= 0;
        var biologia= 0;
        var comunicacion= 0;
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            String preguntaId = entry.getKey().split("_")[1]; // Obtener el id de la pregunta del nombre del campo
            String respuestaSeleccionada = entry.getValue(); // Obtener la alternativa seleccionada por el usuario
            // Procesar la respuesta y guardarla en la base de datos si es necesario
            switch (index){
                case 0: case 1: case 2:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        historia_peru++;
                    }
                    break;
                case 3: case 4: case 5:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        economia++;
                    }
                    break;
                case 6: case 7: case 8:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        filosofia++;
                    }
                    break;
                case 9: case 10: case 11:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        historia_universal++;
                    }
                    break;
                case 12: case 13: case 14:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        biologia++;
                    }
                    break;
                case 15: case 16: case 17:
                    if (preguntaService.verificarRespuesta(Integer.parseInt(preguntaId),Integer.parseInt(respuestaSeleccionada))){
                        comunicacion++;
                    }
                    break;
            }


            index++;
        }

        if (skill == null){
            Skill skillObject = new Skill();

            skillObject.setUsuario_id(usuario.getId());
            skillObject.setHistoria_peru_b(historia_peru);
            skillObject.setEconomia_b(economia);
            skillObject.setFilosofia_b(filosofia);
            skillObject.setHistoria_universal_b(historia_universal);
            skillObject.setBiologia_b(biologia);
            skillObject.setComunicacion_b(comunicacion);
            return  skillRepository.save(skillObject);
        }else {
           // Skill skill = skillRepository.getById(usuario.getId());
            skill.setHistoria_peru_a(skill.getHistoria_peru_b());
            skill.setEconomia_a(skill.getEconomia_b());
            skill.setFilosofia_a(skill.getFilosofia_b());
            skill.setHistoria_universal_a(skill.getHistoria_universal_b());
            skill.setBiologia_a(skill.getBiologia_b());
            skill.setComunicacion_a(skill.getComunicacion_b());


            skill.setHistoria_peru_b(historia_peru);
            skill.setEconomia_b(economia);
            skill.setFilosofia_b(filosofia);
            skill.setHistoria_universal_b(historia_universal);
            skill.setBiologia_b(biologia);
            skill.setComunicacion_b(comunicacion);

            return  skillRepository.save(skill);
        }

    }
}
