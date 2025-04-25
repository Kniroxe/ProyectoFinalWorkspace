package com.kirbys.pedidos.dto;

import java.time.LocalDate;
import java.util.Set;

import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.models.entities.Producto;

public class PedidoDTOPut {
    private Long id;

    private Long estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}


}
