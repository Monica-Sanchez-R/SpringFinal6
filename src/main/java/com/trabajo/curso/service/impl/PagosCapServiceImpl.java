package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.curso.model.Capacitacion;
import com.trabajo.curso.model.PagosCapacitacion;
import com.trabajo.curso.repository.CapacitacionRepository;
import com.trabajo.curso.repository.PagosCapRepository;
import com.trabajo.curso.service.PagosCapService;

@Service
public class PagosCapServiceImpl implements PagosCapService{

    private final PagosCapRepository pagoscapRepository;
    private final CapacitacionRepository capacitacionRepository;

    @Autowired
    public PagosCapServiceImpl(PagosCapRepository pagoscapRepository, CapacitacionRepository capacitacionRepository) {
        this.pagoscapRepository = pagoscapRepository;
        this.capacitacionRepository = capacitacionRepository;
    }

    @Override
    public PagosCapacitacion guardarPagosCapacitacion(PagosCapacitacion pagoscapacitacion) {
        return pagoscapRepository.save(pagoscapacitacion);
    }

    @Override
    public PagosCapacitacion actualizarPagosCapacitacion(PagosCapacitacion pagoscapacitacion) {
        return pagoscapRepository.save(pagoscapacitacion);
    }

    @Override
    public void eliminarPagosCapacitacion(Long id) {
    	pagoscapRepository.deleteById(id);
    }

    @Override
    public PagosCapacitacion buscarPagosCapacitacion(Long id) {
        return pagoscapRepository.findById(id).orElse(null);
    }

    @Override
    public Set<PagosCapacitacion> listarPagosCapacitacion() {
        return  new HashSet<>(pagoscapRepository.findAll());
    }

    @Override
    public Set<PagosCapacitacion> listarPagosCapacitacionPorCapacitacion(Long id) {
        Capacitacion capacitacion = capacitacionRepository.findById(id).orElse(null);
        return new HashSet<>(pagoscapRepository.findByCapacitacion(capacitacion));
    }
}
