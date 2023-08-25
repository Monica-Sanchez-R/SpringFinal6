package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajo.curso.model.Administrativo;
import com.trabajo.curso.repository.AdministrativoRepository;
import com.trabajo.curso.service.AdministrativoService;


@Service
public class AdministrativoServiceImpl implements AdministrativoService {

    private final AdministrativoRepository administrativoRepository;

    @Autowired
    public AdministrativoServiceImpl(AdministrativoRepository administrativoRepository) {
        this.administrativoRepository = administrativoRepository;
    }
    @Override
    @Transactional
    public Administrativo crearAdministrativo(Administrativo administrativo) throws Exception {
    	Administrativo administrativoLocal = administrativoRepository.findByUsuariorol(administrativo.getUsuariorol());
        if (administrativoLocal != null) {
            throw new Exception("El detalleadministrativo ya existe");
        } else {
        	administrativoLocal = administrativoRepository.save(administrativo);
        }
        return administrativoLocal;

    }

    @Override
    @Transactional
    public Administrativo actualizarAdministrativo(Administrativo administrativo) {
        return administrativoRepository.save(administrativo);
    }

    @Override
    @Transactional
    public void eliminarAdministrativo(Long id) throws Exception {
    	administrativoRepository.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Administrativo obtenerAdministrativo(Long id) throws Exception {

        return administrativoRepository.findById(id).orElseThrow(() -> new Exception("El administrativo no existe"));
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Administrativo> listarAdministrativos() {
        return new HashSet<>(administrativoRepository.findAll());
    }
}
