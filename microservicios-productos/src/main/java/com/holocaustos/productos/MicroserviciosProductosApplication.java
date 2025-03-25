package com.holocaustos.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.holocaustos.productos.models.entities", "com.holocaustos.pedidos.models.entities"})
public class MicroserviciosProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosProductosApplication.class, args);
	}

}
