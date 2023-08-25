package com.trabajo.curso.service;

import java.util.List;
import com.trabajo.curso.model.Rol;

public interface RolService {

    Rol agrergarRol(Rol rol) throws Exception;

    Rol obtenerRolPorId(Long id);

    void eliminarRol(Long id);

    Rol actualizarRol(Rol rol) throws Exception;

    List<Rol> obtenerRoless();

    Rol obtenerRolPorNombre(String nombre);


}