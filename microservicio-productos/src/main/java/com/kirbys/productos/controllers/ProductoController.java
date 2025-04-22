package com.kirbys.productos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kirbys.commons.controllers.CommonController;
import com.kirbys.productos.dto.ProductoDTO;
import com.kirbys.productos.servicies.ProductoService;

// TODO: service cyan
@RestController
public class ProductoController extends CommonController<ProductoDTO, ProductoService>{
	public ProductoController(ProductoService service) {
		super(service);
	}
}