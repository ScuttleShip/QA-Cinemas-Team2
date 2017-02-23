package com.qa.cinema.service;

public interface MovieService {


	String getAllMovies();

	String addNewMovie(String movieJson);

	String replaceMovie(Integer movieId, String updatedMovie);

	String deleteMovie(Integer movieId);
	
}
