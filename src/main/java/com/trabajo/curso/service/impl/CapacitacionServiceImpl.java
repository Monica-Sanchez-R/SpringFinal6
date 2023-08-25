package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.curso.model.Capacitacion;
import com.trabajo.curso.model.Cliente;
import com.trabajo.curso.repository.CapacitacionRepository;
import com.trabajo.curso.repository.ClienteRepository;
import com.trabajo.curso.service.CapacitacionService;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{

    private final CapacitacionRepository capacitacionRepository;
    private final ClienteRepository clienteRepository;

     @Autowired
    public CapacitacionServiceImpl(CapacitacionRepository capacitacionRepository, ClienteRepository clienteRepository) {
        this.capacitacionRepository = capacitacionRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Capacitacion guardarCapacitacion(Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }

    @Override
    public Capacitacion actualizarCapacitacion(Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }

    @Override
    public void eliminarCapacitacion(Long id) {
        capacitacionRepository.deleteById(id);
    }

    @Override
    public Capacitacion buscarCapacitacionId(Long id) {
        return capacitacionRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Capacitacion> buscarCapacitaciones() {
        return new HashSet<>(capacitacionRepository.findAll());
    }

    @Override
    public Set<Capacitacion> buscarCapacitacionesPorCliente(Long id) {
         Cliente cliente = clienteRepository.findById(id).orElse(null);
        return capacitacionRepository.findByCliente(cliente);
    }
}
