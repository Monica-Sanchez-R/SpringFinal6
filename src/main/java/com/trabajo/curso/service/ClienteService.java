package com.trabajo.curso.service;

import java.util.Set;

import com.trabajo.curso.model.Cliente;

public interface ClienteService {

	Cliente guardarCliente(Cliente cliente) throws Exception;

	Cliente actualizarCliente(Cliente cliente);

	void eliminarCliente(Long id);

	Cliente buscarCliente(Long id) throws Exception;

	Set<Cliente> obtenerClientes();

}