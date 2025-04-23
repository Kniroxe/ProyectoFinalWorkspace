package com.kirbys.clientes.servicies;

import java.util.List;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.servicies.CommonService;

public interface ClienteService extends CommonService<ClienteDTO>{

	public List<Cliente> listarPedidos();
}
