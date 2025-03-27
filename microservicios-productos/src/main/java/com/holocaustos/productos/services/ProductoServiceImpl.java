package com.holocaustos.productos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holocaustos.productos.mappers.ProductoMapper;
import com.holocaustos.productos.models.dto.ProductoDTO;
import com.holocaustos.microservicios.commons.models.entities.Producto;
import com.holocaustos.productos.models.repositories.ProductosRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl implements IProductoService{

	
	@Autowired
	private ProductosRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<ProductoDTO> listar() {
		List<Producto> productoEntity = repository.findAll();
		List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();
		for(Producto c: productoEntity) {
			productoDTO.add(ProductoMapper.entityDto(c));
		}
		return productoDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public ProductoDTO obtenerPorId(Long id) {
		Optional<Producto> optEntity = repository.findById(id);
		if(optEntity.isPresent()) {
			ProductoDTO dto = ProductoMapper.entityDto(optEntity.get());
			return dto;
			}
		return null;
	}

	@Override
	public ProductoDTO crear(ProductoDTO productoDTO) {
		Producto entity = ProductoMapper.dtoEntity(productoDTO);
		entity = repository.save(entity);
		productoDTO = ProductoMapper.entityDto(entity);
		return productoDTO;
	}

	@Override
	public Optional<ProductoDTO> eliminarPorId(Long id) {
		Optional <Producto> producto = repository.findById(id);		
		if(producto.isPresent()) {
			repository.deleteById(id);
			ProductoDTO productoDto = ProductoMapper.entityDto(producto.get());
			return Optional.of(productoDto);
		}
		return Optional.empty();
	}

	@Override
	public Producto actualizar(ProductoDTO productoDto, Long id) {
		Optional<Producto> optProducto = repository.findById(id);
		if (optProducto.isPresent()) {
			Producto modProducto = ProductoMapper.dtoEntity(productoDto);
			modProducto.setIdProducto(id);
			//productoDto = ProductoMapper.entityDto(modProducto);
			return repository.save(modProducto);
		}
		return null;
	}

}
