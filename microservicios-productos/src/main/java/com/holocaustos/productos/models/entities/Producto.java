package com.holocaustos.productos.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="VUELO_SEQ")
	@SequenceGenerator(name="VUELO_SEQ",sequenceName="VUELO_SEQ",allocationSize=1)
	@Column(name= "ID_PRODUCTO")
	private Long idProducto;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PRECIO")
	private Double precio;
	
	@Column(name="STOCK")
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
