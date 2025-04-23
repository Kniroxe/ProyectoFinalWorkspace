package com.kirbys.pedidos.models.repositories;

import com.kirbys.commons.models.entities.Pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT p FROM Pedido p WHERE p.estado<>4")
	List<Pedido> findAllWithEstadoNotCancelado();
	
	@Query("SELECT p FROM Pedido p WHERE p.cliente=:clienteId")
	List<Pedido> finnAllForCliente(@PathVariable("clienteId") Long clienteId);
	
}