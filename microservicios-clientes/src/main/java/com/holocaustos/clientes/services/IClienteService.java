package com.holocaustos.clientes.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.clientes.models.entities.Cliente;

public interface IClienteService { //Generico es redundante en diseño Microservice

	List<Cliente> listar();
	Optional<Cliente> obtenerPorId(Long id);
	Cliente crear(Cliente cliente);
	Optional<Cliente> eliminarPorId(Long id);
	Cliente actualizar(Cliente cliente, Long id);
	
}
