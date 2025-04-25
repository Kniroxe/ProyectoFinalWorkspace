package com.kirbys.pedidos.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.models.entities.Estado;
import com.kirbys.commons.models.entities.Producto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

public class PedidoDTO {

    private Long id;

    @NotNull(message = "El cliente no puede ser nulo")
    private Cliente cliente;

	@NotNull(message = "Los productos no deben ser nulos")
	private List<Producto> productos;
    
    @Min(value = 0, message = "El total no puede ser negativo")
    private Long total;
    
    @PastOrPresent(message = "La fecha de creación debe ser anterior a la fecha actual")
    private LocalDate fechaCreacion;
    
    //cambiado
    //@Min(value = 1, message = "El estado debe ser mínimo 1")
    //@Max(value = 4, message = "El estado debe ser máximo 4")
    private Long estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}