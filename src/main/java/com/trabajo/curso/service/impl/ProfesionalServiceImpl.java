package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.curso.model.Profesional;
import com.trabajo.curso.repository.ProfesionalRepository;
import com.trabajo.curso.service.ProfesionalService;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {
	
    private final ProfesionalRepository profesionalRepository;

    @Autowired
    public ProfesionalServiceImpl(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    @Override
    public Profesional guardarProfesional(Profesional profesional) throws Exception {
        Profesional profesionalLocal = profesionalRepository.findByUsuariorol(profesional.getUsuariorol());

        if (profesionalLocal != null) {
            throw new Exception("El detalleprofesional ya existe");
        } else {
        	profesionalLocal = profesionalRepository.save(profesional);
        }
        return profesionalLocal;
    }

    @Override
    public Profesional actualizarProfesional(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }

    @Override
    public void eliminarProfesional(Long id) {
    	profesionalRepository.deleteById(id);
    }

    @Override
    public Profesional obtenerProfesional(Long id) {
        return profesionalRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Profesional> listarProfesionales() {
        return new HashSet<>(profesionalRepository.findAll());
    }
}
