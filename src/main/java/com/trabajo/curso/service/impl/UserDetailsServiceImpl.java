package com.trabajo.curso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.repository.UsuarioRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}
