package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.Capacitacion;

public interface CapacitacionService {

    Capacitacion guardarCapacitacion(Capacitacion capacitacion);

    Capacitacion actualizarCapacitacion(Capacitacion capacitacion);

    void eliminarCapacitacion(Long id);

    Capacitacion buscarCapacitacionId(Long id);

    Set<Capacitacion> buscarCapacitaciones();

    Set<Capacitacion> buscarCapacitacionesPorCliente(Long id);

}
