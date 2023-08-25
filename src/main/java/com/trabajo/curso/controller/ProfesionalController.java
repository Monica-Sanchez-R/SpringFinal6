package com.trabajo.curso.controller;

import java.util.Set;

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

import com.trabajo.curso.model.Profesional;
import com.trabajo.curso.service.ProfesionalService;



@RestController
@RequestMapping("/profesional")
@CrossOrigin("*")
public class ProfesionalController {

    private final ProfesionalService profesionalService;

    @Autowired
    public ProfesionalController(ProfesionalService profesionalService) {
        this.profesionalService = profesionalService;
    }

    @PostMapping("/")
    public ResponseEntity<Profesional> guardarProfesional(@RequestBody Profesional profesional) throws Exception {
        return ResponseEntity.ok(profesionalService.guardarProfesional(profesional));
    }

    @PutMapping("/")
    public ResponseEntity<Profesional> actualizarProfesional(@RequestBody Profesional profesional) {
        return ResponseEntity.ok(profesionalService.actualizarProfesional(profesional));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProfesional(@PathVariable("id") Long id) {
    	profesionalService.eliminarProfesional(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesional> obtenerProfesional(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesionalService.obtenerProfesional(id));
    }

    @GetMapping("/")
    public ResponseEntity<Set<Profesional>> listarProfesionales() {
        return ResponseEntity.ok(profesionalService.listarProfesionales());
    }

}
