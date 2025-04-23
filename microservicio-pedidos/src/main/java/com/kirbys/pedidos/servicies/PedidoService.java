package com.kirbys.pedidos.servicies;

import com.kirbys.commons.servicies.CommonService;
import com.kirbys.pedidos.dto.PedidoDTO;
import com.kirbys.pedidos.dto.PedidoDTOPost;

public interface PedidoService extends CommonService<PedidoDTO> {
	public PedidoDTO insertarPost(PedidoDTOPost dto);
}