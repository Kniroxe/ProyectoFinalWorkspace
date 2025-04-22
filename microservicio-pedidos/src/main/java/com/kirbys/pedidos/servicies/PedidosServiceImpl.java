package com.kirbys.pedidos.servicies;

import org.springframework.stereotype.Service;

import com.kirbys.commons.servicies.CommonServiceImpl;
import com.kirbys.pedidos.dto.PedidoDTO;

@Service
public class PedidosServiceImpl extends 
CommonServiceImpl<PedidoDTO, Pedido, PedidosMapper, PedidoRepository>
implements PedidosService	{

}
