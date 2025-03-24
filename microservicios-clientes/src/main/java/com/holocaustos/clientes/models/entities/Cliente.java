package com.holocaustos.clientes.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES", uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL","TELEFONO" }))
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteSeq")
	@SequenceGenerator(name = "clienteSeq", sequenceName = "CLIENTE_SEQ", allocationSize = 5)
	@Column(name = "ID_CLIENTE")
	private Long idCliente;

	/*
	 * @Column(name="")
	 * 
	 * @NotNull(message="") //Other than String
	 * 
	 * @NotBlank(message="") //String
	 * 
	 * @Min(value=, message="")
	 * 
	 * @Past(message="") //Fecha menor a la actual
	 * 
	 * @Size(max=, message="")
	 * 
	 * @Min(value=1, message="Valores validos de Estatus (1,2)")
	 * 
	 * @JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer"})
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="ID_AEROLINEA",referencedColumnName= "ID_AEROLINEA")
	 */

	@NotBlank(message = "El Nombre es REQUERIDO")
	@Column(name = "NOMBRE")
	private String nombre;

	@NotBlank(message = "El Apellido es REQUERIDO")
	@Column(name = "APELLIDO") 
	private String apellido;

	@NotBlank(message = "El Email es REQUERIDO")
	@Column(name = "EMAIL") 
	private String email;

	@NotBlank(message = "El Telefono es REQUERIDO")
	@Column(name = "TELEFONO") 
	private String telefono;

	@Size(max = 100, message = "La direccion no debe exceder 100 caracteres")
	@Column(name = "DIRECCION") 
	private String direccion;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
