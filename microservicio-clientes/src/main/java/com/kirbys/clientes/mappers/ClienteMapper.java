package com.kirbys.clientes.mappers;

import org.springframework.stereotype.Component;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.models.repositories.ClienteRepository;
import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Cliente;

@Component
public class ClienteMapper extends CommonMapper<ClienteDTO, Cliente, ClienteRepository>{

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
        return entity;
    }

}