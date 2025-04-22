package com.kirbys.productos.mappers;

import org.springframework.stereotype.Component;

import com.kirbys.commons.mappers.CommonMapper;
import com.kirbys.productos.dto.ProductoDTO;

@Component
public class ProductoMapper extends CommonMapper<ProductoDTO, Producto, ProductoRepository>{

}
