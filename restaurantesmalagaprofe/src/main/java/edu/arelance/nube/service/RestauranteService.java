package edu.arelance.nube.service;

import java.util.Optional;

import edu.arelance.nube.repository.entity.Restaurante;

public interface RestauranteService {
	
	Iterable<Restaurante> consultarTodos ();
	
	Optional<Restaurante> consultarRestaurante (Long id);
	
	Restaurante altaRestaurante (Restaurante restaurante);
	
	void borrarRestaurante (Long id);
	
	Optional<Restaurante> modificarRestaurante (Long id, Restaurante restaurante);
	
	Iterable<Restaurante> buscarPorRangoPrecio (int preciomin, int preciomax);

	Iterable<Restaurante> buscarPorBarrioNombreOEspecialidad (String clave);
}
