package com.kirbys.clientes.mappers;

import org.springframework.stereotype.Component;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.models.repositories.ClienteRepository;
import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Cliente;

@Component
public class ClienteMapper extends CommonMapper<ClienteDTO, Cliente, ClienteRepository>{

}
