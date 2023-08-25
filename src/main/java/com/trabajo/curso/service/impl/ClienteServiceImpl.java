package com.trabajo.curso.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.curso.model.Cliente;
import com.trabajo.curso.repository.ClienteRepository;
import com.trabajo.curso.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) throws Exception {
    	Cliente clienteLocal = clienteRepository.findByUsuariorol(cliente.getUsuariorol());

        if (clienteLocal != null) {
            throw new Exception("El detallecliente ya existe");
        } else {
        	clienteLocal = clienteRepository.save(cliente);
        }
        return clienteLocal;
    }

    @Override
    public Cliente actualizarCliente(Cliente Cliente) {
        return clienteRepository.save(Cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
    	clienteRepository.deleteById(id);

    }

    @Override
    public Cliente buscarCliente(Long id) throws Exception {
        return clienteRepository.findById(id).orElseThrow(() -> new Exception("El detallecliente no existe."));
    }

    @Override
    public Set<Cliente> obtenerClientes() {
        return  new HashSet<>(clienteRepository.findAll());
    }
}
