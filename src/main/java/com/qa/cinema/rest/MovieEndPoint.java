package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.MovieService;

@Path("/movie")
public class MovieEndPoint {
	
	@Inject
	private MovieService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllMovies(){
		return service.getAllMovies();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getMovieById(@PathParam("id") Long movieId){
		return service.getMovieById(movieId);
	}
	
	@Path("/json/title/{title}")
	@GET
	@Produces({"application/json"})
	public String getMovieByTitle(@PathParam("title") String movieTitle){
		return service.getMovieByTitle(movieTitle);
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String addMovie(String movie){
		return service.addNewMovie(movie);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateMovie(@PathParam("id") Long movieId, String movie){
		return service.replaceMovie(movieId, movie);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteMovie(@PathParam("id") Long movieId, String movie){
		return service.deleteMovie(movieId);
	}

}
