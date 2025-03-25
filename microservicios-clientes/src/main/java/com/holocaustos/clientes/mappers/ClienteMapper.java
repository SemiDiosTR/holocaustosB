package com.holocaustos.clientes.mappers;

import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.microservicios.commons.models.entities.Cliente;

public class ClienteMapper {

	/*
	@Autowired
	private static AerolineaClient aerolineaClient;
	FEIGN END */
	
	
	public static ClienteDTO entitytoDto(Cliente cliente) {
		if (cliente == null) {
			return null;
		}
		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setIdCliente(cliente.getIdCliente());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellido(cliente.getApellido());
		clienteDto.setDireccion(cliente.getDireccion());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setTelefono(cliente.getTelefono());
		return clienteDto;
	}

	
	public static Cliente dtoToEntity (ClienteDTO clienteDto) {
		if (clienteDto == null) {
			return null;
		}
		Cliente cliente = new Cliente();
		cliente.setIdCliente(clienteDto.getIdCliente());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setApellido(clienteDto.getApellido());
		cliente.setDireccion(clienteDto.getDireccion());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setTelefono(clienteDto.getTelefono());
		
		/*VIA FEIGN
		Optional<Aerolinea> aerolinea = aerolineaClient.getAerolineaById(avionDto.getIdAerolinea());
		avion.setAerolinea(aerolinea.isPresent() ? aerolinea.get(): null);
		FEIGN END*/
		return cliente;
		
	}
}
