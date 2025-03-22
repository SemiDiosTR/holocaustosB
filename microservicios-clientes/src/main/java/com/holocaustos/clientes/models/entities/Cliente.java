package com.holocaustos.clientes.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente {

	//TODO VALIDAR LOS CAMPOS DE LA TABLA (not null, min,max, etc)
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="VUELO_SEQ")
	@SequenceGenerator(name="VUELO_SEQ",sequenceName="VUELO_SEQ", allocationSize=1)
	@Column(name= "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="APELLIDO")
	private String apellido;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="DIRECCION")
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
