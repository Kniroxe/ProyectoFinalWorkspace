package com.kirbys.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({"com.kirbys.commons.models.entities"})
@EnableFeignClients
public class MicroservicioPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPedidosApplication.class, args);
	}

}
