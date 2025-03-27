package com.holocaustos.pedidos.models.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.holocaustos.pedidos.models.enums.Estado;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PedidoDTO {
	
	private Long idPedido;

    @NotNull(message = "El Id del Cliente es requerido")
    private Long idCliente; // not null

    @NotNull(message = "Los Productos son requeridos")
    private List<Long> idProductos = new ArrayList<Long>();
    
    @NotNull(message = "El Total es requerido")
    @Positive(message = "El Total debe ser mayor a 0")
    private Double total;
    
    @NotNull(message = "La Fecha de Creacion es requerida")
    private LocalDate fechaCreacion;

    @NotNull(message = "El Estado es requerido")
    private Long estado;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public List<Long> getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(List<Long> idProductos) {
		this.idProductos = idProductos;
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
