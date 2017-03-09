package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
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
	public String replaceMovie(Long movie_ID, String updatedMovie) {
		Movie updateMovie = util.getObjectForJSON(updatedMovie, Movie.class);
		Movie movie = findMovie(Long.valueOf(movie_ID));
		if (movie != null) {
			updateMovie.setMovie_ID(movie.getMovie_ID());
			movie = updateMovie;
			em.merge(movie);
		}
		return "{\"message\": \"movie sucessfully updated\"}";
	}

	@Override
	public String deleteMovie(Long movie_ID) {
		Movie movie = findMovie(Long.valueOf(movie_ID));
		if (movie != null) {
			em.remove(movie);
		}
		return "{\"message\": \"movie sucessfully removed\"}";
	}

	private Movie findMovie(Long movie_ID) {
		return em.find(Movie.class, movie_ID);
	}	
}