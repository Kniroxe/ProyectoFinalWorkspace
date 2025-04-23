package com.kirbys.pedidos.controllers;

import com.kirbys.pedidos.servicies.PedidoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirbys.commons.controllers.CommonController;
import com.kirbys.pedidos.dto.PedidoDTO;
import com.kirbys.pedidos.dto.PedidoDTOPost;

@RestController
public class PedidoController extends CommonController<PedidoDTO, PedidoService>{
	public PedidoController(PedidoService service) {
		super(service);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> post(@Valid PedidoDTOPost dto, BindingResult result) {
		if(result.hasErrors()) {
			return this.validate(result);
		}
		return ResponseEntity.ok(service.insertarPost(dto));
	}

}
