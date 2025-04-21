package com.kirbys.commons.servicies;

import java.util.List;
import java.util.Optional;

public interface CommonService<D> {

	List<D> listar();
	
	Optional<D> obtenerPorId(Long id);
	
	D editar(D entity, Long id);
	
	D insertar(D entity);
	
	D eliminar(Long id);
		
}
