package com.kirbys.pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kirbys.commons.models.entities.Producto;

@FeignClient(name ="microservicio-productos")
public interface ProductoClient {

	@GetMapping("/{id}")
	public Producto getProductoById(@PathVariable Long id);
}
