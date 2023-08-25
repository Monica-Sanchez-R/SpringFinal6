package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.Administrativo;


public interface AdministrativoService {

    Administrativo crearAdministrativo(Administrativo administrativo) throws Exception;

    Administrativo actualizarAdministrativo(Administrativo administrativo);

    void eliminarAdministrativo(Long id) throws Exception;

    Administrativo obtenerAdministrativo(Long id) throws Exception;

    Set<Administrativo> listarAdministrativos();
}
