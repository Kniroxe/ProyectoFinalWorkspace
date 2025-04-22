package com.kirbys.productos.servicies;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kirbys.commons.models.entities.Producto;
import com.kirbys.commons.servicies.CommonServiceImpl;
import com.kirbys.productos.dto.ProductoDTO;
import com.kirbys.productos.mappers.ProductoMapper;
import com.kirbys.productos.models.repositories.ProductoRepository;

@Service
public class ProductosServiceImpl  extends 
CommonServiceImpl<ProductoDTO, Producto, ProductoMapper, ProductoRepository>
implements ProductoService {

	@Override
	@Transactional(readOnly = true)
	public List<ProductoDTO> listar() {
		List<ProductoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(Producto ->{
			lista.add(mapper.entityToDTO(Producto));
		});
		return lista;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<ProductoDTO> obtenerPorId(Long id) {
		Optional<Producto> opt = repository.findById(id);
	       if(opt.isPresent()) {
	    	   return Optional.of(mapper.entityToDTO(opt.get()));
	       }
	       return Optional.empty();
	}
	
	
	@Override
	@Transactional
	public ProductoDTO insertar(ProductoDTO dto) {
		Producto producto = mapper.dtoToEntity(dto);
		repository.save(producto);
		dto.setId(producto.getId());
		return dto;
	}

	
	@Override
	@Transactional
	public ProductoDTO editar(ProductoDTO entity, Long id) {
		Optional<Producto> opt = repository.findById(id);
		if(opt.isPresent()) {
			Producto producto = opt.get();
			producto.setNombre(entity.getNombre());
			producto.setDescripcion(entity.getDescripcion());
			producto.setPrecio(entity.getPrecio());
			producto.setStock(entity.getStock());
			repository.save(producto);
			return mapper.entityToDTO(producto);
		}
		return null;
	}



	@Override
	@Transactional
	public ProductoDTO eliminar(Long id) {
		Optional<Producto> opt = repository.findById(id);
		if (opt.isPresent()) {
			ProductoDTO dto = mapper.entityToDTO(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}

	
	
}
