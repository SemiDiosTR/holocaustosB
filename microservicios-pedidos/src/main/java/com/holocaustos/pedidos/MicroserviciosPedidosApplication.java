package com.holocaustos.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.holocaustos.microservicios.commons.models.entities")
public class MicroserviciosPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPedidosApplication.class, args);
	}

}
