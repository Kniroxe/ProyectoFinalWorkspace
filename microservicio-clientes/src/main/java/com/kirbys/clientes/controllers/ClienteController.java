package com.kirbys.clientes.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.servicies.ClienteService;
import com.kirbys.commons.controllers.CommonController;
import com.kirbys.commons.models.entities.Cliente;

@RestController
public class ClienteController extends CommonController<ClienteDTO, ClienteService>{
	public ClienteController(ClienteService service) {
		super(service);
	}
	
	/*@GetMapping("listarPedidosCliente/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id){
		Optional<Cliente> dto = service.obtenerPorId(id);
		if(dto.isPresent()) {
			return ResponseEntity.ok(dto.get());
		}
		return ResponseEntity.notFound().build();
	}*/
}
