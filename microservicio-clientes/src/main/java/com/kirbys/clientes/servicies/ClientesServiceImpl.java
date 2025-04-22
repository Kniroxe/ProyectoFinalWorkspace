package com.kirbys.clientes.servicies;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.mappers.ClienteMapper;
import com.kirbys.clientes.models.repositories.ClienteRepository;
import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.servicies.CommonServiceImpl;

public class ClientesServiceImpl extends 
CommonServiceImpl<ClienteDTO, Cliente, ClienteMapper, ClienteRepository>
implements ClienteService	{

}
