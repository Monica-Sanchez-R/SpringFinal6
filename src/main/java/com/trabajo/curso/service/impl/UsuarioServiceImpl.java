package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajo.curso.exception.UsuarioFoundException;
import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.model.UsuarioRol;
import com.trabajo.curso.repository.RolRepository;
import com.trabajo.curso.repository.UsuarioRepository;
import com.trabajo.curso.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            throw new UsuarioFoundException("El usuario ya esta presente");
        } else {
            for (UsuarioRol usuarioRol : usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Usuario> obtenerUsuarios() {
        return new HashSet<>(usuarioRepository.findAll());
    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal;

        usuarioLocal = usuarioRepository.save(usuario);

        return usuarioLocal;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    @Override
    @Transactional
    public Usuario actualizarContrasena(Usuario usuario) throws Exception {
        return usuarioRepository.save(usuario);
    }
}
