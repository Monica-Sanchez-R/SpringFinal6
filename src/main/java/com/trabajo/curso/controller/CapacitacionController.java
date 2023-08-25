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

import com.trabajo.curso.model.Capacitacion;
import com.trabajo.curso.service.CapacitacionService;


@RestController
@RequestMapping("/capacitaciones")
@CrossOrigin("*")
public class CapacitacionController {

    private final CapacitacionService capacitacionService;

    @Autowired
    public CapacitacionController(CapacitacionService capacitacionService) {
        this.capacitacionService = capacitacionService;
    }

    @PostMapping("/")
    public ResponseEntity<Capacitacion> guardarCapacitacion(@RequestBody Capacitacion capacitacion)  {
        return ResponseEntity.ok(capacitacionService.guardarCapacitacion(capacitacion));
    }

    @PutMapping("/")
    public ResponseEntity<Capacitacion> actualizarCapacitacion(@RequestBody Capacitacion capacitacion)  {
        return ResponseEntity.ok(capacitacionService.actualizarCapacitacion(capacitacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCapacitacion(@PathVariable("id") Long id) {
        capacitacionService.eliminarCapacitacion(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capacitacion> buscarCapacitacionPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(capacitacionService.buscarCapacitacionId(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> buscarCapacitaciones() {
        return ResponseEntity.ok(capacitacionService.buscarCapacitaciones());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> buscarCapacitacionesPorDetalleCliente(@PathVariable("id") Long id) {
        return ResponseEntity.ok(capacitacionService.buscarCapacitacionesPorCliente(id));
    }

}
