package com.holocaustos.clientes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holocaustos.clientes.mappers.ClienteMapper;
import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.clientes.models.repositories.ClientesRepository;
import com.holocaustos.microservicios.commons.models.entities.Cliente;


@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClientesRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<ClienteDTO> listar() {
		List<Cliente> clientesEntity = repository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for(Cliente c: clientesEntity) {
			clientesDTO.add(ClienteMapper.entitytoDto(c));
		}
		return clientesDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public ClienteDTO obtenerPorId(Long id) {
		Optional<Cliente> optEntity = repository.findById(id);
		if(optEntity.isPresent()) {
			ClienteDTO dto = ClienteMapper.entitytoDto(optEntity.get());
			return dto;
		}
		return null; 
	}

	
	@Override
	@Transactional
	public ClienteDTO crear(ClienteDTO clienteDto) {
		Cliente entity = ClienteMapper.dtoToEntity(clienteDto);
		entity = repository.save(entity);
		clienteDto = ClienteMapper.entitytoDto(entity);
		return clienteDto;
	}

	@Override
	@Transactional
	public Optional<ClienteDTO> eliminarPorId(Long id) {
		Optional <Cliente> cliente = repository.findById(id);		
		if(cliente.isPresent()) {
			repository.deleteById(id);
			ClienteDTO clienteDto = ClienteMapper.entitytoDto(cliente.get());
			return Optional.of(clienteDto);
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public ClienteDTO actualizar(ClienteDTO clienteDto, Long id) {
		Optional<Cliente> optCliente = repository.findById(id);
		if (optCliente.isPresent()) {
			Cliente modCliente = ClienteMapper.dtoToEntity(clienteDto);
			repository.save(modCliente);
			clienteDto = ClienteMapper.entitytoDto(modCliente);
			return clienteDto;
		}
		return null;
	}
	
	

}
