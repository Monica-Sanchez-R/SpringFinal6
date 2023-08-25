package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.curso.model.Asistentes;
import com.trabajo.curso.model.Capacitacion;
import com.trabajo.curso.repository.AsistentesRepository;
import com.trabajo.curso.repository.CapacitacionRepository;
import com.trabajo.curso.service.AsistentesService;


@Service
public class AsistentesServiceImpl implements AsistentesService {

    private final AsistentesRepository asistentesRepository;
    private final CapacitacionRepository capacitacionRepository;

    @Autowired
    public AsistentesServiceImpl(AsistentesRepository asistentesRepository, CapacitacionRepository capacitacionRepository) {
        this.asistentesRepository = asistentesRepository;
        this.capacitacionRepository = capacitacionRepository;
    }
    @Override
    public Asistentes guardarAsistentes(Asistentes asistentes)  {

        return asistentesRepository.save(asistentes);
    }

    @Override
    public Asistentes actualizarAsistentes(Asistentes asistentes) {
        return asistentesRepository.save(asistentes);
    }

    @Override
    public void eliminarAsistentes(Long id) {
        asistentesRepository.deleteById(id);
    }

    @Override
    public Asistentes buscarAsistentes(Long id) {
        return asistentesRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Asistentes> obtenerAsistentes() {
        return new HashSet<>(asistentesRepository.findAll());
    }

    @Override
    public Set<Asistentes> obtenerAsistentesPorCapacitacion(Long id) {
        Capacitacion capacitacion = capacitacionRepository.findById(id).orElse(null);
        return new HashSet<>(asistentesRepository.findAsistentesByCapacitacion(capacitacion));
    }
}

