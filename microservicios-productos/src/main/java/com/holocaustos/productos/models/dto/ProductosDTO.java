package com.holocaustos.productos.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductosDTO {
		
		private Long idProducto;

		@NotBlank(message = "El Nombre es REQUERIDO")
		private String nombre; // not null

		@NotBlank(message = "La descripcion es requerido")
		private String descripcion;
		
		@NotNull(message = "el Precio es requerido")
		private Double precio;
		
		@NotNull(message = "el Stock es requerido")
		private Long stock;

		public Long getIdProducto() {
			return idProducto;
		}

		public void setIdProducto(Long idProducto) {
			this.idProducto = idProducto;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public Long getStock() {
			return stock;
		}

		public void setStock(Long stock) {
			this.stock = stock;
		}

		
		
}
