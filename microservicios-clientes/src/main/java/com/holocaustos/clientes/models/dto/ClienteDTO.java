package com.holocaustos.clientes.models.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
	
	private Long idCliente;

	
	@NotBlank(message = "El Nombre es REQUERIDO")
	private String nombre; // not null

	@NotBlank(message = "El Apellido es REQUERIDO")
	private String apellido;

	@NotBlank(message = "El Email es REQUERIDO")
	private String email;

	@NotBlank(message = "El Telefono es REQUERIDO")
	private String telefono;

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
