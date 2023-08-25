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

import com.trabajo.curso.model.Asistentes;
import com.trabajo.curso.service.AsistentesService;


@RestController
@RequestMapping("/asistentes")
@CrossOrigin("*")
public class AsistentesController {

    private AsistentesService asistentesService;

    @Autowired
    public AsistentesController(AsistentesService asistentesService) {
        this.asistentesService = asistentesService;
    }


    @PostMapping("/")
    public ResponseEntity<Asistentes> guardarAsistentes(@RequestBody Asistentes asistentes){
        return ResponseEntity.ok(asistentesService.guardarAsistentes(asistentes));
    }


    @PutMapping("/")
    public ResponseEntity<Asistentes> actualizarAsistentes(@RequestBody Asistentes asistentes){
        return ResponseEntity.ok(asistentesService.actualizarAsistentes(asistentes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistentes> obtenerAsistentesPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(asistentesService.buscarAsistentes(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsistentesPorId(@PathVariable("id") Long id){
        asistentesService.eliminarAsistentes(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar/")
    public ResponseEntity<Iterable<Asistentes>> obtenerAsistentes(){
        return ResponseEntity.ok(asistentesService.obtenerAsistentes());
    }

    @GetMapping("/capacitacion/{id}")
    public ResponseEntity<Iterable<Asistentes>> obtenerAsistentesPorCapacitacion(@PathVariable("id") Long id){
        return ResponseEntity.ok(asistentesService.obtenerAsistentesPorCapacitacion(id));
    }

}