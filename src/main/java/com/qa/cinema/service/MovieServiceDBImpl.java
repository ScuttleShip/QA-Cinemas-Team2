package com.qa.cinema.service;

import java.awt.print.Book;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

public class MovieServiceDBImpl implements MovieService{


	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllMovies() {
		Query query = em.createQuery("SELECT m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);
	}

	@Override
	public String addNewMovie(String movieJson) {
		Movie newMovie = util.getObjectForJSON(movieJson, Movie.class);
		em.persist(newMovie);
		return movieJson;
	}

	@Override
	public String replaceMovie(Integer movieId, String updatedMovie) {
		Movie updateMovie = util.getObjectForJSON(updatedMovie, Movie.class);
		Movie movie = findMovie(new Long(movieId));
		if (movie != null) {
			movie = updateMovie;
			em.merge(movie);
		}
		return "{\"message\": \"movie sucessfully updated\"}";
	}

	@Override
	public String deleteMovie(Integer movieId) {
		Movie movie = findMovie(new Long(movieId));
		if (movie != null) {
			em.remove(movie);
		}
		return "{\"message\": \"movie sucessfully removed\"}";
	}

	private Movie findMovie(Long id) {
		return em.find(Movie.class, id);
	}
	
}
