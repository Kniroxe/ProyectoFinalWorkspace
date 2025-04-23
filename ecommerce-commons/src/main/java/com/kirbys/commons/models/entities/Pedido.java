package com.kirbys.commons.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {
	  
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDOS")
	@SequenceGenerator(name="SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS", allocationSize = 1)
	@Column(name="ID_PEDIDO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CLIENTE", referencedColumnName = "ID_CLIENTE")
	@JsonBackReference
	private Cliente cliente;
	
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "LISTA_PRODUCTOS",
			joinColumns = @JoinColumn(name = "ID_PEDIDO"),
			inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO")
			)
	private List<Producto> productos;
	
	
	@Column(name = "TOTAL")
	private Long total;
	
	@Column(name = "FECHA_CREACION")
	private LocalDate fechaCreacion;
	
	@Column(name ="ID_ESTADO")
	private Long estado;
	
	
	public Pedido() {
		this.productos = new ArrayList<>();
	}

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

	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", productos=" + productos + ", total=" + total
				+ ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + "]";
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

}