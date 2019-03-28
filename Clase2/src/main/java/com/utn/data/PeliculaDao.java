package com.utn.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.utn.entity.PeliculaEntity;
import com.utn.model.Pelicula;

/**
 * 
 * Capa que se ocupa de conectar al rest con la base de datos
 *
 */

@Component
public class PeliculaDao {

	// variables globales
	private EntityManagerFactory persistence;
	private EntityManager et;


	public Pelicula peliculaXId(int id) {
		persistence = Persistence.createEntityManagerFactory("JPAUTN");
		EntityManager et = persistence.createEntityManager();
		
		PeliculaEntity pentity = et.find(PeliculaEntity.class, id);
		Pelicula p = new Pelicula();
		p.setTitulo(pentity.getTitulo());
		p.setDescripcion(pentity.getDescripcion());
		return p;
	}

	public String guardarPelicula(Pelicula pelicula) {
		
		persistence = Persistence.createEntityManagerFactory("JPAUTN");
		EntityManager et = persistence.createEntityManager();
		
		try {
			et.getTransaction().begin();
			PeliculaEntity pe = new PeliculaEntity();
			pe.setTitulo(pelicula.getTitulo());
			pe.setDescripcion(pelicula.getDescripcion());
			et.persist(pe);
			et.getTransaction().commit();
			return "guardo OK";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "No guardo hubo problemas";
		}
	}
	
	
	

}
