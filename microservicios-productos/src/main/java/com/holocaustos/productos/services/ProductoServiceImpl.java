package com.holocaustos.productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holocaustos.productos.models.entities.Producto;
import com.holocaustos.productos.models.repositories.ProductosRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductosRepository repository;
	
	@Override
	@Transactional
	public List<Producto> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Producto crear(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Producto> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Producto actualizar(Producto producto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
