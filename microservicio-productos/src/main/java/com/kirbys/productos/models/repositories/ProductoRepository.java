package com.kirbys.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kirbys.commons.models.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}