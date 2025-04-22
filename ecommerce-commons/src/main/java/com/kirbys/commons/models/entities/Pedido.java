package com.kirbys.commons.models.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Cliente cliente;
	
	
	
	/*
	 * @ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "POKEMON_TIPO",
			joinColumns = @JoinColumn(name = "ID_POKEMON"),
			inverseJoinColumns = @JoinColumn(name = "ID_TIPO")
			)

	private Set<Tipo> tipos;
	*/
	
	@Column(name = "TOTAL")
	private Long total;
	
	@Column(name = "FECHA_CREACION ")
	private LocalDate fechaCreacion;
	
	@Column(name = "ID_ESTADO")
	private Long estado;


	
	

}
