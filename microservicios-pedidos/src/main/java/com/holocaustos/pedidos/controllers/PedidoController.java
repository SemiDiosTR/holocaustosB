package com.holocaustos.pedidos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.holocaustos.pedidos.models.dto.PedidoDTO;
import com.holocaustos.pedidos.services.IPedidoService;

import jakarta.validation.Valid;

@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@GetMapping //lo convierte en un manejador para solicitudes HTTP GET
	public ResponseEntity<List<PedidoDTO>> getAll(){ //devuelve una respuesta http con con un cuerpo que contiene una lista de objetos
		return ResponseEntity.ok(service.listar());//devuelve la lista de productos
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> getById(@PathVariable Long id) {
		System.out.println("getByID="+id+ "(Entity)="+service.obtenerPorId(id));
		Optional<PedidoDTO> entity = Optional.of(service.obtenerPorId(id));
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PostMapping
	public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoDTO pedidoDto, BindingResult result){
		System.out.println("START CREATE...");
		if(result.hasErrors()) {
			return (ResponseEntity<PedidoDTO>) this.validar(result);//pedidoDto, se quito de los parentecis ************
		}
		System.out.println("Pedido Controller HAS ERRORS Estado="+pedidoDto.getEstado());
		
		pedidoDto = service.crear(pedidoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PedidoDTO> delete(@PathVariable Long id){
		Optional <PedidoDTO> optPedidoDto = service.eliminarPorId(id);
		if(optPedidoDto.isPresent()) {
			return ResponseEntity.ok(optPedidoDto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO pedidoDto, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return (ResponseEntity<PedidoDTO>) this.validar(result);
		}
		pedidoDto = service.actualizar(pedidoDto, id);
		
		if (pedidoDto != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idPed}/productos/{idPro}")
	public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO pedidoDto, BindingResult result,
			@PathVariable Long idPro,@PathVariable Long idPed) {
		System.out.println("IDPRO="+idPro+ "  IDPED="+idPed);
		
		if (result.hasErrors()) {
			return (ResponseEntity<PedidoDTO>) this.validar(result);
		}
		pedidoDto = service.actualizar(pedidoDto, idPro);
		
		if (pedidoDto != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDto);
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
