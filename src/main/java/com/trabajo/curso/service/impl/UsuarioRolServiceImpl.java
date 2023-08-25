package com.trabajo.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajo.curso.model.Rol;
import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.model.UsuarioRol;
import com.trabajo.curso.repository.RolRepository;
import com.trabajo.curso.repository.UsuarioRepository;
import com.trabajo.curso.repository.UsuarioRolRepository;
import com.trabajo.curso.service.UsuarioRolService;

import jakarta.persistence.EntityManager;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;
    private final EntityManager entityManager;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioRolServiceImpl(UsuarioRolRepository usuarioRolRepository, EntityManager entityManager, UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
        this.entityManager = entityManager;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    @Transactional
    public UsuarioRol guardarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRol> obtenerUsuarioRolUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioRolRepository.findByUsuario(usuario);
    }

    @Override
    @Transactional
    public void eliminarUsuarioRol(Long usuarioRolId) {
        eliminarroles(usuarioRolId);
        entityManager.flush();
        usuarioRolRepository.deleteById(usuarioRolId);
    }

    @Transactional
    public void eliminarroles(Long usuarioRolId) {

        UsuarioRol usuarioRol1 = usuarioRolRepository.findById(usuarioRolId).orElseThrow(() -> new RuntimeException("UsuarioRol no encontrado"));

        usuarioRol1.setUsuario(null);
        usuarioRol1.setRol(null);

        usuarioRolRepository.save(usuarioRol1);
        entityManager.flush();
        entityManager.clear();
        entityManager.detach(usuarioRol1);
        entityManager.close();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRol> obtenerUsuarioRol() {
        return usuarioRolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRol> obtenerUsuarioRolRol(Long rolId) {
        Rol rol = rolRepository.findById(rolId).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        return usuarioRolRepository.findByRol(rol);
    }

    @Override
    @Transactional
    public UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
        return usuarioRolRepository.save(usuarioRol);
    }
}
