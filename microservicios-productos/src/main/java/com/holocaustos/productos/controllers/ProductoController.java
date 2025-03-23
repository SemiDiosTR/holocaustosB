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
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAll(){
		return ResponseEntity.ok(service.listar());
	}
}
