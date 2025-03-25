package com.holocaustos.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holocaustos.productos.models.entities.Producto;
import com.holocaustos.productos.services.IProductoService;

@RestController
public class ProductoController {

	
	@Autowired
	private IProductoService service;
	
	@GetMapping //lo convierte en un manejador para solicitudes HTTP GET
	public ResponseEntity<List<Producto>> getAll(){ //devuelve una respuesta http con con un cuerpo que contiene una lista de objetos
		return ResponseEntity.ok(service.listar());//devuelve la lista de productos
		
	}
}
