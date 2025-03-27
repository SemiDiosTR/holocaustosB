package com.holocaustos.productos.mappers;

import org.springframework.stereotype.Component;

import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.dto.ProductoDTO;

@Component
public class ProductoMapper {
	
	public static ProductoDTO entityDto(Producto producto) {
		if (producto == null) {
			return null;
		}
		ProductoDTO productoDto = new ProductoDTO();
		productoDto.setIdProducto(producto.getIdProducto());
		productoDto.setNombre(producto.getNombre());
		productoDto.setDescripcion(producto.getDescripcion());
		productoDto.setPrecio(producto.getPrecio());
		productoDto.setStock(producto.getStock());
		return productoDto;
	}
	
	public static Producto dtoEntity(ProductoDTO productosDto) {
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
