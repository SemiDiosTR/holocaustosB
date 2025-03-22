package com.holocaustos.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holocaustos.clientes.models.entities.Cliente;
import com.holocaustos.clientes.services.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(service.listar());
	}
	
}
