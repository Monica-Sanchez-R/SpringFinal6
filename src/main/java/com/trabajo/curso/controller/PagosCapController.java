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

import com.trabajo.curso.model.PagosCapacitacion;
import com.trabajo.curso.service.PagosCapService;

@RestController
@RequestMapping("/pagosCapacitacion")
@CrossOrigin("*")
public class PagosCapController {

    private final PagosCapService pagosCapService;

    @Autowired
    public PagosCapController(PagosCapService pagosCapService) {
        this.pagosCapService = pagosCapService;
    }

    @PostMapping("/")
    public ResponseEntity<PagosCapacitacion> guardarPagosCapacitacion(PagosCapacitacion pagosCapacitacion) {
        return ResponseEntity.ok(pagosCapService.guardarPagosCapacitacion(pagosCapacitacion));
    }

    @PutMapping("/")
    public ResponseEntity<PagosCapacitacion> actualizarPagosCapacitacion(@RequestBody PagosCapacitacion pagosCapacitacion)  {
        return ResponseEntity.ok(pagosCapService.actualizarPagosCapacitacion(pagosCapacitacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPagosCapacitacion(@PathVariable("id") Long id)  {
    	pagosCapService.eliminarPagosCapacitacion(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagosCapacitacion> buscarPagosCapacitacion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pagosCapService.buscarPagosCapacitacion(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPagosCapacitacion(){
        return ResponseEntity.ok(pagosCapService.listarPagosCapacitacion());
    }

    @GetMapping("/capacitacion/{id}")
    public ResponseEntity<?> listarPagosCapacitacionPorCapacitacion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pagosCapService.listarPagosCapacitacionPorCapacitacion(id));
    }


}
