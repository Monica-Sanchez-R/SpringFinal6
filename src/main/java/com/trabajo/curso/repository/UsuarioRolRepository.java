package com.trabajo.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Rol;
import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.model.UsuarioRol;

@Repository
@EnableJpaRepositories
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    List<UsuarioRol> findByUsuario(Usuario usuario);

    List<UsuarioRol> findByRol(Rol rol);


}