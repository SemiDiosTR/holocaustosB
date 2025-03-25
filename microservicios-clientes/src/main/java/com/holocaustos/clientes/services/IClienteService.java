package com.holocaustos.clientes.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.microservicios.commons.models.entities.Cliente;
import com.holocaustos.microservicios.commons.services.CommonService;

public interface IClienteService{ //Generico es redundante en diseño Microservice

	List<ClienteDTO> listar();
	ClienteDTO obtenerPorId(Long id);
	Cliente crear(Cliente cliente);
	Optional<Cliente> eliminarPorId(Long id);
	Cliente actualizar(Cliente cliente, Long id);
	
}
