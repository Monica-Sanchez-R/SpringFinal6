package com.trabajo.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Cliente;
import com.trabajo.curso.model.UsuarioRol;


@Repository
@EnableJpaRepositories
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByUsuariorol(UsuarioRol usuariorol);

}