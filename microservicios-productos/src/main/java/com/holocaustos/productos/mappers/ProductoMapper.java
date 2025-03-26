package com.holocaustos.productos.mappers;

import org.springframework.stereotype.Component;

import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.dto.ProductosDTO;

@Component
public class ProductoMapper {
	
	public static ProductosDTO entityDto(Producto producto) {
		if (producto == null) {
			return null;
		}
		ProductosDTO productoDto = new ProductosDTO();
		productoDto.setIdProducto(producto.getIdProducto());
		productoDto.setNombre(producto.getNombre());
		productoDto.setDescripcion(producto.getDescripcion());
		productoDto.setPrecio(producto.getPrecio());
		productoDto.setStock(producto.getStock());
		return productoDto;
	}
	
	public static Producto dtoEntity(ProductosDTO productosDto) {
		if(productosDto == null) {
			return null;
		}
		Producto producto = new Producto();
		producto.setIdProducto(productosDto.getIdProducto());
		producto.setNombre(productosDto.getNombre());
		producto.setDescripcion(productosDto.getDescripcion());
		producto.setPrecio(productosDto.getPrecio());
		producto.setStock(productosDto.getStock());
		
		return producto;
	}

}
