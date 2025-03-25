package com.holocaustos.clientes.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.holocaustos.microservicios.commons.models.entities.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long>{

}
