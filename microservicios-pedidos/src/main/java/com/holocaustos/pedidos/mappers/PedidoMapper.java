package com.holocaustos.pedidos.mappers;

import org.springframework.stereotype.Component;

import com.holocaustos.microservicios.commons.models.entities.Pedido;
import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.pedidos.models.dto.PedidoDTO;
import com.holocaustos.pedidos.models.enums.Estado;

@Component
public class PedidoMapper {

	public static PedidoDTO entityDto(Pedido pedido) {
		if (pedido == null) {
			return null;
		}
		PedidoDTO pedidoDto = new PedidoDTO();
		pedidoDto.setIdPedido(pedido.getIdPedido());
		if (pedido.getCliente() != null) {
			pedidoDto.setIdCliente(pedido.getCliente().getIdCliente());
		}

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

	public static Pedido dtoEntity(PedidoDTO pedidoDto) {
		if (pedidoDto == null) {
			return null;
		}
		Pedido pedido = new Pedido();
		pedido.setIdPedido(pedidoDto.getIdPedido());

		//FETCH ENTITY FROM DB
		System.out.println("Pedido Mapper DTO=" + pedidoDto );
		pedido.getCliente().setIdCliente(pedidoDto.getIdCliente());

		// IMPLEMENTAR VIA FEIGN (Basado en Aerolinea Client)
		// meter IDs en una lista de Objetos

		// iterar la lista,
		for (Long idProducto : pedidoDto.getIdProductos()) {
			// vaciar de Dto a Objeto.id
			pedido.getProductos().add(new Producto(idProducto));
			
		}
		
		pedido.setTotal(pedidoDto.getTotal());
		pedido.setFechaCreacion(pedidoDto.getFechaCreacion());
		pedido.setEstado(pedidoDto.getEstado());
		return pedido;
	}

}
