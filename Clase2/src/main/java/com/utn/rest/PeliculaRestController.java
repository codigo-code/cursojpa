package com.utn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.data.PeliculaDao;
import com.utn.model.Pelicula;

@RestController
public class PeliculaRestController {

	@Autowired
	private PeliculaDao peliculaDao;

	@GetMapping(value = "/getPelicula/{id}")
	public Pelicula getPelicula(@PathVariable("id") int id) {
		try {
			return this.peliculaDao.peliculaXId(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@PostMapping(value = "guardoPelicula")
	public String guardoPelicula(Pelicula pelicula) {
		try {
			return peliculaDao.guardarPelicula(pelicula);
		} catch (Exception e) {
			return "hubo un error";
		}
	}
}
