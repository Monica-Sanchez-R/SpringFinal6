package com.trabajo.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.curso.model.UsuarioRol;
import com.trabajo.curso.service.UsuarioRolService;


@RestController
@RequestMapping("/usuario/rol")
@CrossOrigin("*")
public class UsuarioRolController {
	
    private final UsuarioRolService usuarioRolService;

    @Autowired
    public UsuarioRolController(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioRol> guardarUsuarioRol(@RequestBody UsuarioRol usuarioRol) throws Exception {
        return ResponseEntity.ok(usuarioRolService.guardarUsuarioRol(usuarioRol));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<UsuarioRol>> obtenerUsuarioRolUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return ResponseEntity.ok(usuarioRolService.obtenerUsuarioRolUsuario(usuarioId));
    }

    @DeleteMapping("/{usuarioRolId}")
    public ResponseEntity<?> eliminarUsuarioRol(@PathVariable("usuarioRolId") Long usuarioRolId) {
        usuarioRolService.eliminarUsuarioRol(usuarioRolId);
        return ResponseEntity.ok(usuarioRolId + " eliminado");
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioRol>> obtenerUsuarioRol() {
        return ResponseEntity.ok(usuarioRolService.obtenerUsuarioRol());
    }

    @GetMapping("/rol/{rolId}")
    public ResponseEntity<List<UsuarioRol>> obtenerUsuarioRolRol(@PathVariable("rolId") Long rolId) {
        return ResponseEntity.ok(usuarioRolService.obtenerUsuarioRolRol(rolId));
    }

    @PutMapping("/")
    public ResponseEntity<UsuarioRol> actualizarUsuarioRol(@RequestBody UsuarioRol usuarioRol) throws Exception {
        return ResponseEntity.ok(usuarioRolService.actualizarUsuarioRol(usuarioRol));
    }
}