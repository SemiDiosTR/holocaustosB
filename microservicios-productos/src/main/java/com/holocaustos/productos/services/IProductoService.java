package com.holocaustos.productos.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.productos.models.entities.Producto;

public interface IProductoService {
	
	List<Producto> listar();
	Optional<Producto> obtenerPorId(Long id);
	Producto crear(Producto producto);
	Optional<Producto> eliminarPorId(Long id);
	Producto actualizar(Producto producto, Long id);
	
	
	
	

}
