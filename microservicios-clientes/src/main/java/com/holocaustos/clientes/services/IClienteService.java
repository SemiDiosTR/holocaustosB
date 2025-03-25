package com.holocaustos.clientes.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.microservicios.commons.models.entities.Cliente;

public interface IClienteService{ //Generico es redundante en diseño Microservice

	List<ClienteDTO> listar();
	ClienteDTO obtenerPorId(Long id);
	ClienteDTO crear(ClienteDTO clienteDto);
	Optional<ClienteDTO> eliminarPorId(Long id);
	ClienteDTO actualizar(ClienteDTO clienteDto, Long id);
	
}
