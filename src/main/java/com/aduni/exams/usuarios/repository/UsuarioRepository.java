package com.aduni.exams.usuarios.repository;

import com.aduni.exams.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.estado = 'A' and u.rol = 'E' ORDER BY u.id DESC ")
    List<Usuario> findEstudiantesActivos();

    @Query("SELECT u FROM Usuario u WHERE u.estado = 'A' and u.rol = 'A' ORDER BY u.id DESC ")
    List<Usuario> findAdministradoresActivos();

    @Query("SELECT u FROM Usuario u WHERE u.codigo = :codigo")
    List<Usuario>  existUsuario(@Param("codigo") String codigo);
    @Query("SELECT u FROM Usuario u WHERE u.codigo = :codigo ")
    List<Usuario>  findUserByCodigo(@Param("codigo") String codigo);
}

