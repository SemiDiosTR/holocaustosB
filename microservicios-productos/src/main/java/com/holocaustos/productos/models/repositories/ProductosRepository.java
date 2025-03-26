package com.holocaustos.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.holocaustos.microservicios.commons.models.entities.Producto;


public interface ProductosRepository extends JpaRepository<Producto,Long> {

}
