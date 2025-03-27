package com.holocaustos.pedidos.mappers;

import org.springframework.stereotype.Component;

import com.holocaustos.microservicios.commons.models.entities.Pedido;
import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.pedidos.models.dto.PedidoDTO;
import com.holocaustos.pedidos.models.enums.Estado;

@Component //se quita component para prueba*********************************
public class PedidoMapper {
	
	public static PedidoDTO entityDto(Pedido pedido) {
		if (pedido == null) {
			return null;
		}
		PedidoDTO pedidoDto = new PedidoDTO();
		pedidoDto.setIdPedido(pedido.getIdPedido());
		pedidoDto.setIdCliente(pedido.getIdCliente());

		// meter productos en una lista,
		// iterar la lista,
		for (Producto producto : pedido.getProductos()) {
			// vaciar de objeto a id
			pedidoDto.getIdProductos().add(producto.getIdProducto());
		}

		pedidoDto.setTotal(pedido.getTotal());
		pedidoDto.setFechaCreacion(pedido.getFechaCreacion());
		pedidoDto.setEstado(pedido.getEstado());
		return pedidoDto;
	}

	
	public static Pedido dtoEntity(PedidoDTO pedidosDto) {
		if (pedidosDto == null) {
			return null;
		}
		Pedido pedido = new Pedido();
		pedido.setIdPedido(pedidosDto.getIdPedido());
		pedido.setIdCliente(pedidosDto.getIdCliente());
		
		
		//IMPLEMENTAR VIA FEIGN (Basado en Aerolinea Client)
//		// meter productos en una lista de IDs
//
//		// iterar la lista,
//		for (Producto producto : pedido.getProductos()) {
//			// vaciar de objeto a id
//			pedidoDto.getIdProductos().add(producto.getIdProducto());
//			pedido.setProductos(productosRe.);
//			
//		}
//		
		pedido.setTotal(pedidosDto.getTotal());
		pedido.setFechaCreacion(pedidosDto.getFechaCreacion());
		pedido.setEstado(pedidosDto.getEstado());
		return pedido;
	}

}
