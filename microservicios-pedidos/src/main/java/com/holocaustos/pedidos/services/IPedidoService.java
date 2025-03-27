package com.holocaustos.pedidos.services;

import java.util.List;
import java.util.Optional;

import com.holocaustos.microservicios.commons.models.entities.Pedido;
import com.holocaustos.pedidos.models.dto.PedidoDTO;

public interface IPedidoService {
	
	List<PedidoDTO> listar();
	PedidoDTO obtenerPorId(Long id);
	PedidoDTO crear(PedidoDTO pedidosDto);
	Optional<PedidoDTO> eliminarPorId(Long id);
	PedidoDTO actualizar(PedidoDTO pedidosDto, Long id);
	

}
