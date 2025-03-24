package com.holocaustos.clientes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holocaustos.clientes.mappers.ClienteMapper;
import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.clientes.models.entities.Cliente;
import com.holocaustos.clientes.models.repositories.ClientesRepository;


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
	public Optional<Cliente> obtenerPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Cliente crear(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Optional<Cliente> eliminarPorId(Long id) {
		Optional <Cliente> entity = repository.findById(id);
		if(entity.isPresent()) {
			repository.deleteById(id);
			return entity;
		}
		return Optional.empty();
	}

	@Override
	public Cliente actualizar(Cliente cliente, Long id) {
		Optional<Cliente> optCliente = repository.findById(id);
		if (optCliente.isPresent()) {
			Cliente clienteDB = optCliente.get();
			clienteDB.setNombre(cliente.getNombre());
			clienteDB.setApellido(cliente.getApellido());
			clienteDB.setDireccion(cliente.getDireccion());
			clienteDB.setEmail(cliente.getEmail());
			clienteDB.setTelefono(cliente.getTelefono());
			repository.save(clienteDB);
			return clienteDB;
		}
		return null;
	}
	
	

}
