package com.trabajo.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Administrativo;
import com.trabajo.curso.model.UsuarioRol;


@Repository
@EnableJpaRepositories
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {

    Administrativo findByUsuariorol(UsuarioRol usuarioRol);

}