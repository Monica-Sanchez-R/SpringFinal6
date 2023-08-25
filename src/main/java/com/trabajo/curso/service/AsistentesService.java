package com.trabajo.curso.service;

import java.util.Set;
import com.trabajo.curso.model.Asistentes;

public interface AsistentesService {

    Asistentes guardarAsistentes(Asistentes asistentes);

    Asistentes actualizarAsistentes(Asistentes asistentes);

    void eliminarAsistentes(Long id);

    Asistentes buscarAsistentes(Long id);

    Set<Asistentes> obtenerAsistentes();

    Set<Asistentes> obtenerAsistentesPorCapacitacion(Long id);

}