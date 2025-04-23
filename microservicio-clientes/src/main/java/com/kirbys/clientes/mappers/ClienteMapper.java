package com.kirbys.clientes.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.models.repositories.ClienteRepository;
import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.models.entities.Pedido;

@Component
public class ClienteMapper extends CommonMapper<ClienteDTO, Cliente, ClienteRepository>{
//quitar los pedidos
    @Override
    public ClienteDTO entityToDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setDireccion(entity.getDireccion());
        List<Pedido> pedidos = new ArrayList<>();
        entity.getPedidos().forEach(pedido->{
        	pedidos.add(pedido);
        });
        dto.setPedidos(pedidos);
        return dto;
    }

    @Override
    public Cliente dtoToEntity(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setDireccion(dto.getDireccion());
        
        List<Pedido> pedidos = new ArrayList<>();
        dto.getPedidos().forEach(pedido->{
        	pedidos.add(pedido);
        });
        entity.setPedidos(pedidos);
        return entity;
    }

}