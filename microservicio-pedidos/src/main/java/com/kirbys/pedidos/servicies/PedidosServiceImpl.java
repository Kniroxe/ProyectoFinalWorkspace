package com.kirbys.pedidos.servicies;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kirbys.commons.models.entities.Estado;
import com.kirbys.commons.models.entities.Pedido;
import com.kirbys.commons.servicies.CommonServiceImpl;
import com.kirbys.pedidos.dto.PedidoDTO;
import com.kirbys.pedidos.dto.PedidoDTOPost;
import com.kirbys.pedidos.mappers.PedidosMapper;
import com.kirbys.pedidos.models.repositories.PedidoRepository;

@Service
public class PedidosServiceImpl extends 
CommonServiceImpl<PedidoDTO, Pedido, PedidosMapper, PedidoRepository>
implements PedidoService	{
    private static final Logger logger = LoggerFactory.getLogger(PedidosServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<PedidoDTO> listar() {
		List<PedidoDTO> lista = new ArrayList<>();
		repository.findAllWithEstadoNotCancelado().forEach(linea->{
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PedidoDTO> obtenerPorId(Long id) {
		Optional<Pedido> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDTO(optTipo.get()));
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public PedidoDTO insertar(PedidoDTO dto) {
		Pedido pedido = mapper.dtoToEntity(dto);
		repository.save(pedido);
		dto.setId(pedido.getId());
		System.out.println(pedido.toString());
		return mapper.entityToDTO(pedido);
	}

	@Override
	@Transactional
	public PedidoDTO insertarPost(PedidoDTOPost dto) {
		System.out.println(dto.getId());
		logger.info(Long.toString(dto.getId()));
		Pedido pedido = mapper.dtoToEntityPost(dto);
		//repository.save(pedido);
		dto.setId(pedido.getId());
		return mapper.entityToDTO(pedido);
	}
	
	@Override
	@Transactional
	public PedidoDTO editar(PedidoDTO dto, Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if(opt.isPresent()) {
			Pedido pedido = opt.get();
			pedido.setEstado(dto.getEstado());
			repository.save(pedido);			 
			return mapper.entityToDTO(pedido);
		}
		return null;		 
	}

	@Override
	@Transactional
	public PedidoDTO eliminar(Long id) {
		Optional<Pedido> opt = repository.findById(id);
		if(opt.isPresent()) {

			Pedido pedido = opt.get();
			pedido.setEstado(4L);
			//repository.deleteById(id);
			return mapper.entityToDTO(pedido);
		}
		return null;
		/*Optional<Pedido> opt = repository.findById(id);
		if(opt.isPresent()) {
			opt.get().setEstado(4L);
			PedidoDTO dto = mapper.entityToDTO(opt.get());
			Pedido pedido = repository.save(mapper.dtoToEntity(dto));
			//repository.deleteById(id);
			return mapper.entityToDTO(pedido);
		}
		return null;*/
	}

	@Override
	@Transactional
	public List<PedidoDTO> listarPorCliente(Long id) {
		List<PedidoDTO> lista = new ArrayList<>();
		repository.findAllWithEstadoNotCancelado().forEach(linea->{
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}
}
