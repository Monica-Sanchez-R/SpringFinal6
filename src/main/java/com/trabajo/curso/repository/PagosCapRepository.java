package com.trabajo.curso.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.trabajo.curso.model.Capacitacion;
import com.trabajo.curso.model.PagosCapacitacion;

@Repository
@EnableJpaRepositories
public interface PagosCapRepository extends JpaRepository<PagosCapacitacion, Long> {

    Set<PagosCapacitacion> findByCapacitacion (Capacitacion capacitacion);

}
