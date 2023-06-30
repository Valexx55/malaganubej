package edu.arelance.nube.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.arelance.nube.repository.entity.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {

	//1 KEY WORD QUERIES - Consultas por palabras clave
	//obtener restaurantes en un rango de precio
	
	Iterable<Restaurante> findByPrecioBetween (int preciomin, int preciomax);
	
	
	//2 JPQL - HQL - Pseduo SQL pero de JAVA - "Agnóstico" x
	//3 NATIVAS - SQL
	
	@Query(value = "SELECT * FROM bdrestaurantes.restaurantes WHERE barrio LIKE %?1% OR nombre LIKE %?1% OR especialidad1 LIKE %?1% OR especialidad2 LIKE %?1% OR especialidad3 LIKE %?1% ", nativeQuery = true)
	Iterable<Restaurante> buscarPorBarrioNombreOEspecialidad (String clave);
	
	//4 STORED PROCEDURES - Procedimientos Almacenados x
	//5 CRITERIA API - SQL pero con métodos de JAVA https://www.arquitecturajava.com/jpa-criteria-api-un-enfoque-diferente/ x
	
}







