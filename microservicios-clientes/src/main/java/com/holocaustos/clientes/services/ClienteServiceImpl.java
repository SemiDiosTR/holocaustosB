package com.holocaustos.clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holocaustos.clientes.models.entities.Cliente;
import com.holocaustos.clientes.models.repositories.ClientesRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClientesRepository repository;
	
	@Override
	@Transactional
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Cliente crear(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Cliente actualizar(Cliente cliente, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
