package com.trabajo.curso.controller;

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

import com.trabajo.curso.model.Administrativo;
import com.trabajo.curso.service.AdministrativoService;



@RestController
@RequestMapping("/administrativo")
@CrossOrigin("*")
public class AdministrativoController {

    private final AdministrativoService administrativoService;

    @Autowired
    public AdministrativoController(AdministrativoService administrativoService) {
        this.administrativoService = administrativoService;
    }

    @PostMapping("/")
    public ResponseEntity<Administrativo> crearDetalleAdministrativo(@RequestBody Administrativo administrativo) throws Exception {
        return ResponseEntity.ok(administrativoService.crearAdministrativo(administrativo));
    }

    @PutMapping("/")
    public ResponseEntity<Administrativo> actualizarDetalleAdministrativo(@RequestBody Administrativo administrativo) throws Exception {
        return ResponseEntity.ok(administrativoService.actualizarAdministrativo(administrativo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalleAdministrativo(@PathVariable("id") Long id) throws Exception {
    	administrativoService.eliminarAdministrativo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrativo> obtenerDetalleAdministrativo(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(administrativoService.obtenerAdministrativo(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarDetalleAdministrativos() {
        return ResponseEntity.ok(administrativoService.listarAdministrativos());
    }

}
