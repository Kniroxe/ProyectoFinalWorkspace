package com.kirbys.productos.mappers;

import org.springframework.stereotype.Component;

import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.commons.models.entities.Producto;
import com.kirbys.productos.dto.ProductoDTO;
import com.kirbys.productos.models.repositories.ProductoRepository;

@Component
public class ProductoMapper extends CommonMapper<ProductoDTO, Producto, ProductoRepository>{

	@Override
	public ProductoDTO entityToDTO(Producto entity) {
		ProductoDTO dto = new ProductoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setDescripcion(entity.getDescripcion());
		dto.setPrecio(entity.getPrecio());
		dto.setStock(entity.getStock());
		return dto;
	}
	
	@Override
	public Producto dtoToEntity(ProductoDTO dto) {
		Producto entity = new Producto();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setDescripcion(dto.getDescripcion());
		entity.setPrecio(dto.getPrecio());
		entity.setStock(dto.getStock());
		return entity;
	}
	
}
