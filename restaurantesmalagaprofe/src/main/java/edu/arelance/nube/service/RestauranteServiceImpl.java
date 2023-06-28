package edu.arelance.nube.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.arelance.nube.repository.RestauranteRepository;
import edu.arelance.nube.repository.entity.Restaurante;

@Service
public class RestauranteServiceImpl implements RestauranteService{

	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Override
	@Transactional(readOnly = true)//permitimos acceso concurrente a la tabla Restaurantes
	public Iterable<Restaurante> consultarTodos() {
		return this.restauranteRepository.findAll();
		//return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Restaurante> consultarRestaurante(Long id) {
		 return this.restauranteRepository.findById(id);
		//return Optional.empty();
	}

	@Override
	@Transactional
	public Restaurante altaRestaurante(Restaurante restaurante) {
		return this.restauranteRepository.save(restaurante);
		//return null;
	}

	@Override
	@Transactional
	public void borrarRestaurante(Long id) {
		this.restauranteRepository.deleteById(id);
	}

	@Override
	public Optional<Restaurante> modificarRestaurante(Long id, Restaurante restaurante) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
