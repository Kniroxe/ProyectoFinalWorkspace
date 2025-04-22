package com.kirbys.productos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kirbys.commons.controllers.CommonController;
import com.kirbys.productos.dto.ProductoDTO;

@RestController
public class ProductoController extends CommonController<ProductoDTO, ProductoService>{
	public ProductoController(ProductoService service) {
		super(service);
	}
}
