package com.holocaustos.productos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.dto.ProductoDTO;
import com.holocaustos.productos.services.IProductoService;

import jakarta.validation.Valid;

@RestController
public class ProductoController{

	
	@Autowired
	private IProductoService service;
	
	@GetMapping //lo convierte en un manejador para solicitudes HTTP GET
	public ResponseEntity<List<ProductoDTO>> getAll(){ //devuelve una respuesta http con con un cuerpo que contiene una lista de objetos
		return ResponseEntity.ok(service.listar());//devuelve la lista de productos
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> getById(@PathVariable Long id) {
		Optional<ProductoDTO> entity = Optional.of(service.obtenerPorId(id));
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PostMapping
	public ResponseEntity<ProductoDTO> create(@Valid @RequestBody ProductoDTO productoDto, BindingResult result){
		if(result.hasErrors()) {
			return (ResponseEntity<ProductoDTO>) this.create(productoDto, result);
		}
		productoDto = service.crear(productoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductoDTO> delete(@PathVariable Long id){
		Optional <ProductoDTO> optProductoDto = service.eliminarPorId(id);
		if(optProductoDto.isPresent()) {
			return ResponseEntity.ok(optProductoDto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ProductoDTO productoDto, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		productoDto = service.actualizar(productoDto, id);
		if (productoDto != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(productoDto);
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
