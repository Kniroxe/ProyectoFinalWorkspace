package com.kirbys.pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kirbys.commons.models.entities.Cliente;

@FeignClient(name ="microservicio-clientes")
public interface ClienteClient {

	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id);
}
