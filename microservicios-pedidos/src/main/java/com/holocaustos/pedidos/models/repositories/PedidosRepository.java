package com.holocaustos.pedidos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.holocaustos.microservicios.commons.models.entities.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido,Long>{

}
