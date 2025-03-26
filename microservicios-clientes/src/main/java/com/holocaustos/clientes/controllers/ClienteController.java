package com.holocaustos.clientes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.holocaustos.clientes.models.dto.ClienteDTO;
import com.holocaustos.clientes.services.IClienteService;

import jakarta.validation.Valid;

@RestController
//mandar a llama el puerto de angular, en donde enviaremos los datos
//@CrossOrigin(value = "http://localhost:4200") 
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		System.out.println("CLIENTE CONTROLLER....");
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		Optional<ClienteDTO> entity = Optional.of(service.obtenerPorId(id));
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDto, BindingResult result){
		if(result.hasErrors()) {
			return (ResponseEntity<ClienteDTO>) this.validar(result);
		}
		clienteDto = service.crear(clienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long id){
		Optional <ClienteDTO> optClienteDto = service.eliminarPorId(id);
		if(optClienteDto.isPresent()) {
			return ResponseEntity.ok(optClienteDto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO clienteDto, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return (ResponseEntity<ClienteDTO>) this.validar(result);
		}
		clienteDto = service.actualizar(clienteDto, id);
		if (clienteDto != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String,Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(),err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
