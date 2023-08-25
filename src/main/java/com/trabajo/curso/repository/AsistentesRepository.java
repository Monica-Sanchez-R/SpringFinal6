package com.trabajo.curso.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Asistentes;
import com.trabajo.curso.model.Capacitacion;

@Repository
@EnableJpaRepositories
public interface AsistentesRepository extends JpaRepository<Asistentes, Long> {

    Set<Asistentes> findAsistentesByCapacitacion (Capacitacion capacitacion);



}