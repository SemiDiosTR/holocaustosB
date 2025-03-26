package com.holocaustos.productos.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.dto.ProductosDTO;

public interface IProductoService {
	
	//List<Productos> listar();
	//Optional<Producto> obtenerPorId(Long id);
	//Producto crear(Producto producto);
	//Optional<Producto> eliminarPorId(Long id);
	//Producto actualizar(Producto producto, Long id);
	
	List<ProductosDTO> listar();
	ProductosDTO obtenerPorId(Long id);
	ProductosDTO crear(ProductosDTO productoDto);
	Optional<ProductosDTO> eliminarPorId(Long id);
	Producto actualizar(ProductosDTO productoDto, Long id);
	
	

}
