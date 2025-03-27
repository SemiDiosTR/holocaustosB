package com.holocaustos.productos.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.dto.ProductoDTO;

public interface IProductoService {
	
	//List<Productos> listar();
	//Optional<Producto> obtenerPorId(Long id);
	//Producto crear(Producto producto);
	//Optional<Producto> eliminarPorId(Long id);
	//Producto actualizar(Producto producto, Long id);
	
	List<ProductoDTO> listar();
	ProductoDTO obtenerPorId(Long id);
	ProductoDTO crear(ProductoDTO productoDto);
	Optional<ProductoDTO> eliminarPorId(Long id);
	Producto actualizar(ProductoDTO productoDto, Long id);
	
	

}
