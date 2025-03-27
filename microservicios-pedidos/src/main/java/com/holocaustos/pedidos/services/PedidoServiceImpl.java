package com.holocaustos.pedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holocaustos.pedidos.mappers.PedidoMapper;
import com.holocaustos.pedidos.models.dto.PedidoDTO;
import com.holocaustos.microservicios.commons.models.entities.Pedido;
import com.holocaustos.pedidos.models.repositories.PedidosRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class PedidoServiceImpl implements IPedidoService{

	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<PedidoDTO> listar() {
		List<Pedido> pedidoEntity = pedidosRepository.findAll();
		List<PedidoDTO> pedidoDTO = new ArrayList<PedidoDTO>();
		for(Pedido p: pedidoEntity) {
			pedidoDTO.add(PedidoMapper.entityDto(p));
		}
		return pedidoDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public PedidoDTO obtenerPorId(Long id) {
		Optional<Pedido> optEntity = pedidosRepository.findById(id);
		if(optEntity.isPresent()) {
			PedidoDTO dto = PedidoMapper.entityDto(optEntity.get());
			return dto;
			}
		return null;
	}

	@Override
	@Transactional //se agrega posible cambio**********************************
	public PedidoDTO crear(PedidoDTO pedidoDTO) {
		Pedido entity = PedidoMapper.dtoEntity(pedidoDTO);
		entity = pedidosRepository.save(entity);
		pedidoDTO = PedidoMapper.entityDto(entity);
		return pedidoDTO;
	}

	@Override
	@Transactional
	public Optional<PedidoDTO> eliminarPorId(Long id) {
		Optional <Pedido> pedido = pedidosRepository.findById(id);		
		if(pedido.isPresent()) {
			pedidosRepository.deleteById(id);
			PedidoDTO pedidoDto = PedidoMapper.entityDto(pedido.get());
			return Optional.of(pedidoDto);
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public PedidoDTO actualizar(PedidoDTO pedidoDto, Long id) {
		Optional<Pedido> optPedido = pedidosRepository.findById(id);
		if (optPedido.isPresent()) {
			Pedido modPedido = PedidoMapper.dtoEntity(pedidoDto);
			modPedido.setIdPedido(id);
			modPedido = pedidosRepository.save(modPedido);
			pedidoDto= PedidoMapper.entityDto(modPedido);
			return pedidoDto;
		}
		return null;
	}
	
	

}
