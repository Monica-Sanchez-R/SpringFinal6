package com.trabajo.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Rol;


@Repository
@EnableJpaRepositories
public interface RolRepository extends JpaRepository<Rol, Long> {
	
    Rol findBynombre(String nombre);
}
