package com.holocaustos.microservicios.commons.models.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //DEFINE A LA CLASE COMO UA ENTIDAD MAPEADA A UNA TABLA, SINO SE AGREGA NO SERA RECONOCIDA POR LA ENTIDAD JPA
@Table(name = "PEDIDOS")//DEFINE EL NOMBRE DE LA TABLA, SINO SE DEFINE JPA USARA EL NOMBRE DE LA CLASE Y PODRIA NO COINCIDIR CON EL ESQUEMA DE DB
public class Pedido {
	
	@Id //Representa la clave primaria de la tabla para que JPA lo identifique
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="PEDIDO_SEQ") //El valor clave primaria se generara automaticamente mediante una secuencia
	@SequenceGenerator(name="PEDIDO_SEQ",sequenceName="PEDIDO_SEQ",allocationSize=1) //Define un generador de secuencias llamado PEDIDO_SEQ, se utiliza para generar los IDs de esta entidad. El allocationSize=1 asegura que cada ID se incremente en pasos de uno, garantizando unicidad.
	@Column(name="ID_PEDIDO") //Asocia el atributo idPedido con la columna específica de la tabla en la base de datos llamada ID_CLIENTE. También permite mapear el nombre de la columna de la base de datos a un atributo de la clase
	private Long idPedido; //Declara la variable idProducto como un atributo de tipo  en la clase. Este campo se usará para almacenar el valor de la clave primaria generada automáticamente para cada registro.
	
	
	@Column(name="CLIENTE_ID") // Almacena el nombre del pedido. El atributo "name" mapea la columna a este campo.
    // Sin esta línea, no habría vínculo directo con la columna "CLIENTE_ID".

	private Long clienteId;
	
	//TODO Reactivar
	//@Column(name="PRODUCTOS")
	//private List<Producto> productos;
	
	/*  XXX TO FIX
	@ManyToMany
	@JoinTable(
	    name = "PRODUCTOS_PEDIDOS", // Nombre de la tabla intermedia
	    joinColumns = @JoinColumn(name = "ID_PEDIDO"), // Clave foránea hacia Pedido
	    inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO") // Clave foránea hacia Producto
	)
	private List<Producto> productos;
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
	

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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
	 
	
	
	

}
