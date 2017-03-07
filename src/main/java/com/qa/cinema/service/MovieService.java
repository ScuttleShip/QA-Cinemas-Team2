package com.qa.cinema.service;

public interface MovieService {


	String getAllMovies();

	String addNewMovie(String movieJson);

	String replaceMovie(Long movie_ID, String updatedMovie);

	String deleteMovie(Long movie_ID);

	String getMovieById(Long movie_ID);
}
