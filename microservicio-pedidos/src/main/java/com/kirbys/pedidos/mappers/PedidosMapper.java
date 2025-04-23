package com.kirbys.pedidos.mappers;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.models.entities.Pedido;
import com.kirbys.commons.models.entities.Producto;
import com.kirbys.pedidos.clients.ClienteClient;
import com.kirbys.pedidos.clients.ProductoClient;
import com.kirbys.pedidos.dto.PedidoDTO;
import com.kirbys.pedidos.dto.PedidoDTOPost;
import com.kirbys.pedidos.models.repositories.PedidoRepository;

@Component
public class PedidosMapper extends CommonMapper<PedidoDTO, Pedido, PedidoRepository> {

	@Autowired
	ClienteClient clienteClient;
	
	@Autowired
	ProductoClient productoClient;
	
    @Override
    public PedidoDTO entityToDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getId());
        dto.setCliente(entity.getCliente());
        List<Producto> productos = new ArrayList<>();
        entity.getProductos().forEach(producto->{
        	productos.add(producto);
        });
        dto.setProductos(productos);
        dto.setTotal(entity.getTotal());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setEstado(entity.getEstado());
        
        return dto;
    }

    @Override
    public Pedido dtoToEntity(PedidoDTO dto) {
        Pedido entity = new Pedido();
        entity.setId(dto.getId());
        Cliente cliente = clienteClient.getClienteById(dto.getCliente().getId());
        if(cliente!= null)
        	entity.setCliente(cliente);
        
        List<Producto> productos = new ArrayList<>();
        dto.getProductos().forEach(producto->{
			Producto productoTemp = productoClient.getProductoById(producto.getId());
        		if(productoTemp!=null) {// ver si es por esto
            		productos.add(productoTemp);        			
        		}        	
        });
        entity.setProductos(productos);
        entity.setTotal(dto.getTotal());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setEstado(dto.getEstado());

        return entity;
    }
    
    public Pedido dtoToEntityPost(PedidoDTOPost dto) {
        Pedido entity = new Pedido();
        //entity.setId(dto.getId());
        Cliente cliente = clienteClient.getClienteById(dto.getCliente().getId());
        if(cliente!= null)
        	entity.setCliente(cliente);

        List<Producto> productos = new ArrayList<>();
        dto.getProductos().forEach(producto->{
			Optional<Producto> productoTemp = Optional.of(productoClient.getProductoById(producto.getId()));
        	if(productoTemp.isPresent()) {
        		productos.add(productoTemp.get());
        	}
        });
        entity.setProductos(productos);
        entity.setTotal(0L);
        dto.getProductos().forEach(producto->{
			Optional<Producto> productoTemp = Optional.of(productoClient.getProductoById(producto.getId()));
        	if(productoTemp.isPresent()) {
        		//productos.add(productoTemp.get());
        		entity.setTotal(entity.getTotal()+productoTemp.get().getPrecio());
        	}
        });
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setEstado(1L);

        return entity;
    }
}