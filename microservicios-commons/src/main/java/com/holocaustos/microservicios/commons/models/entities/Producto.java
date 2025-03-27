package com.holocaustos.microservicios.commons.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCTOS_SEQ")
	@SequenceGenerator(name="PRODUCTOS_SEQ",sequenceName="PRODUCTOS_SEQ",allocationSize=1)
	@Column(name= "ID_PRODUCTO")
	private Long idProducto;
	
	@Column(name="NOMBRE")
	@NotNull(message = "El nombre del producto es obligatoria")
	//@NotBlank(message = "El nombre del producto no puede estar vacio")
	//@Size(min = 1, max = 50, message = "El nombre del producto debe de estar entre 1 y 50 caracteres")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	//@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
	@Column(name="PRECIO")
	@NotNull(message = "El campo Precio no puede ir vacio")
	private Double precio;
	
	@Column(name="STOCK")
	@NotNull(message = "El campo Stock no puede ir vacio")
	@Min(value = 0, message = "El Stock no puede ser 0")
	private Long stock;//posible cambio por integer
	
	//Relacion de tabla producto y tabla pedido
	@ManyToMany(mappedBy = "productos")
	private List<Pedido> pedidos = new ArrayList<>(); //= new ArrayList<Pedido>(); se comenta para prueba
	//private Set<Pedido> pedidos = new HashSet<>();
	

	public Long getIdProducto() {
		return idProducto;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
