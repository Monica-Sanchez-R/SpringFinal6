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

import com.trabajo.curso.model.Cliente;
import com.trabajo.curso.service.ClienteService;


@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> guardarDetalleCliente(@RequestBody Cliente cliente) throws Exception {
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    @PutMapping("/")
    public ResponseEntity<Cliente> actualizarDetalleCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.actualizarCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalleCliente(@PathVariable("id") Long id) {
    	clienteService.eliminarCliente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarDetalleCliente(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<Set<Cliente>> obtenerDetalleClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }


}
