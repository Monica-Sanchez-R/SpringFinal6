package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.model.UsuarioRol;

public interface UsuarioService {

	Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    Usuario obtenerUsuario(String username);

    void eliminarUsuario(Long usuarioId); // eliminar usuario

    Set<Usuario> obtenerUsuarios(); //lista de todos los usuarios 

    Usuario actualizarUsuario(Usuario usuario) throws Exception;

    Usuario obtenerUsuarioPorId(Long usuarioId); //buscar por id

    Usuario actualizarContrasena(Usuario usuario) throws Exception;
}
