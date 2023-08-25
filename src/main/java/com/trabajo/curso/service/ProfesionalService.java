package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.Profesional;

public interface ProfesionalService {

	Profesional guardarProfesional(Profesional profesional) throws Exception;

	Profesional actualizarProfesional(Profesional profesional);

    void eliminarProfesional(Long id);

    Profesional obtenerProfesional(Long id);

    Set<Profesional> listarProfesionales();

}
