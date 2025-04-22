package com.kirbys.pedidos.mappers;

import org.springframework.stereotype.Component;

import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Pedido;
import com.kirbys.pedidos.dto.PedidoDTO;
import com.kirbys.pedidos.models.repositories.PedidoRepository;

@Component
public class PedidosMapper extends CommonMapper<PedidoDTO, Pedido, PedidoRepository> {

    @Override
    public PedidoDTO entityToDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getId());

        if (entity.getCliente() != null) {
            dto.setClienteId(entity.getCliente().getId());
        }

        dto.setTotal(entity.getTotal());
        dto.setFechaCreacion(entity.getFechaCreacion());

        if (entity.getEstado() != null) {
            dto.setEstadoId(entity.getEstado().getId());
        }

        return dto;
    }

    @Override
    public Pedido dtoToEntity(PedidoDTO dto) {
        Pedido entity = new Pedido();
        entity.setId(dto.getId());
        entity.setTotal(dto.getTotal());
        entity.setFechaCreacion(dto.getFechaCreacion());

        return entity;
    }
}