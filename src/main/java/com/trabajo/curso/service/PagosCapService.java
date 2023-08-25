package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.PagosCapacitacion;


public interface PagosCapService {

	PagosCapacitacion guardarPagosCapacitacion(PagosCapacitacion pagoscapacitacion);

    PagosCapacitacion actualizarPagosCapacitacion(PagosCapacitacion pagoscapacitacion);

    void eliminarPagosCapacitacion(Long id);

    PagosCapacitacion buscarPagosCapacitacion(Long id);

    Set<PagosCapacitacion> listarPagosCapacitacion();

    Set<PagosCapacitacion> listarPagosCapacitacionPorCapacitacion(Long id);

}