package com.kirbys.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.servicies.ClienteService;
import com.kirbys.commons.controllers.CommonController;

@RestController
public class ClienteController extends CommonController<ClienteDTO, ClienteService>{
	public ClienteController(ClienteService service) {
		super(service);
	}
}  
