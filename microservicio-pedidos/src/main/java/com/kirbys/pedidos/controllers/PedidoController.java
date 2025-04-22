package com.kirbys.pedidos.controllers;

import com.kirbys.pedidos.servicies.PedidoService;
import org.springframework.web.bind.annotation.RestController;

import com.kirbys.commons.controllers.CommonController;
import com.kirbys.pedidos.dto.PedidoDTO;


// TODO: service cyan
@RestController
public class PedidoController extends CommonController<PedidoDTO, PedidoService>{
	public PedidoController(PedidoService service) {
		super(service);
	}

}
