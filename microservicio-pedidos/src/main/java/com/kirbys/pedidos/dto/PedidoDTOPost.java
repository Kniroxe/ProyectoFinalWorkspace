package com.kirbys.pedidos.dto;

import java.time.LocalDate;
import java.util.Set;

import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.models.entities.Producto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PedidoDTOPost {

    private Long id;

    @NotNull(message = "El cliente no puede ser nuloooo")
    private Cliente cliente;

	@NotNull(message = "Los productos no deben ser nulos")
	private Set<Producto> productos;
    
    @Past(message = "La fecha de creación debe ser anterior a la fecha actual")
    private LocalDate fechaCreacion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}