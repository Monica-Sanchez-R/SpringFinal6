package com.trabajo.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Usuario;

@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
    Usuario findByUsername(String username);

}

