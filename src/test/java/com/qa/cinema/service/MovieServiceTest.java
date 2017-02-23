package com.qa.cinema.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.util.JSONUtil;
import com.qa.cinema.persistence.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	@InjectMocks
	MovieServiceDBImpl testMovieService;
	
	@Mock
	JSONUtil util;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void getAllMoviesTest() {
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		Movie testMovie = new Movie();
		
		movieList.add(testMovie);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(movieList);
		Mockito.when(util.getJSONForObject(movieList)).thenReturn("test");
		
		
		String jsonForm = util.getJSONForObject(movieList);
		System.out.println(jsonForm);
		
		String toPassIn = util.getJSONForObject(testMovie);
		testMovieService.addNewMovie(toPassIn);
		String assertionString = testMovieService.getAllMovies();
		Assert.assertEquals(assertionString, jsonForm);
		
		Mockito.verify(em).createQuery(Mockito.anyString());
		
		
	}
	
	@Test
	public void addMovieTest() {
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		Movie testMovie = new Movie();
		
		movieList.add(testMovie);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(movieList);
		Mockito.when(util.getJSONForObject(movieList)).thenReturn("test");
		
		
		String jsonForm = util.getJSONForObject(movieList);
		System.out.println(jsonForm);
		
		String toPassIn = util.getJSONForObject(testMovie);
		testMovieService.addNewMovie(toPassIn);
		testMovieService.getAllMovies();
		Assert.assertTrue(movieList.get(0) instanceof Movie);
		
		Mockito.verify(em).createQuery(Mockito.anyString());
		
		
	}
	
	
}

