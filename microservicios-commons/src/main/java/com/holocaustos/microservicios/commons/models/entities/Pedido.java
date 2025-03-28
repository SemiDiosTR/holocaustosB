package com.holocaustos.microservicios.commons.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity //DEFINE A LA CLASE COMO UA ENTIDAD MAPEADA A UNA TABLA, SINO SE AGREGA NO SERA RECONOCIDA POR LA ENTIDAD JPA
@Table(name = "PEDIDOS")//DEFINE EL NOMBRE DE LA TABLA, SINO SE DEFINE JPA USARA EL NOMBRE DE LA CLASE Y PODRIA NO COINCIDIR CON EL ESQUEMA DE DB
public class Pedido {
	
		
	@Id //Representa la clave primaria de la tabla para que JPA lo identifique
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="PEDIDO_SEQ") //El valor clave primaria se generara automaticamente mediante una secuencia
	@SequenceGenerator(name="PEDIDO_SEQ",sequenceName="PEDIDO_SEQ",allocationSize=1) //Define un generador de secuencias llamado PEDIDO_SEQ, se utiliza para generar los IDs de esta entidad. El allocationSize=1 asegura que cada ID se incremente en pasos de uno, garantizando unicidad.
	@Column(name="ID_PEDIDO") //Asocia el atributo idPedido con la columna específica de la tabla en la base de datos llamada ID_CLIENTE. También permite mapear el nombre de la columna de la base de datos a un atributo de la clase
	private Long idPedido; //Declara la variable idProducto como un atributo de tipo  en la clase. Este campo se usará para almacenar el valor de la clave primaria generada automáticamente para cada registro.
	
	@ManyToOne //se agrega +++++++++
	@JoinColumn(name= "ID_CLIENTE",nullable = false)
	@JsonBackReference	
	private Cliente cliente;	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)//se agrega ++++++++++++
	@JoinTable(
	    name = "PEDIDOS_PRODUCTOS", // Nombre de la tabla intermedia
	    joinColumns = @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO"), // Clave foránea hacia Pedido
	    inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO") // Clave foránea hacia Producto
	)
	private List<Producto> productos = new ArrayList<>();//se agrega new ArraysList se movio de antes get set "= new ArrayList<>(); se quita para prueba" ++++++++++++++	
		

	/*
	@Column(name="ID_CLIENTE", insertable = false, updatable = false) // Almacena el nombre del pedido. El atributo "name" mapea la columna a este campo.
    // Sin esta línea, no habría vínculo directo con la columna "CLIENTE_ID".
	private Long idCliente;
	*/

	@Column(name="TOTAL")
	private Double total;

	@Column(name="FECHA_CREACION")
	private LocalDate fechaCreacion;
	
	@Column(name="ESTADO")
	private Long estado;
	
	
	
	//Relacion entre tabla pedido y producto
	//@ManyToMany
	//@JoinTable(name = "Productos_Pedidos", 
	//joinColumns = @JoinColumn(name = "idProductos"),
	//inverseJoinColumns = @JoinColumn(name = "idPedidos"))
	

	
	public Pedido() {
		this.cliente = new Cliente();
		this.productos = new ArrayList<>(); //se agrega para prueba ++++++++++++++
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//public Cliente getCliente() {
	//	return cliente;
	//}

	//public void setCliente(Cliente cliente) {
	//	this.cliente = cliente;
	//}
	 

}
