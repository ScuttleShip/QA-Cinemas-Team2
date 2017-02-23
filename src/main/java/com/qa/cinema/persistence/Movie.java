package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	@GeneratedValue
	@Id
	Long movie_ID;
	String title;
	String description;
	String genre;
	String duration;
	String certification;

	public Movie() {

	}

	public Movie(String title, String description, String genre,
			String duration, String certification) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.certification = certification;
	}

	public Long getMovie_ID() {
		return movie_ID;
	}

	public void setMovie_ID(Long movie_ID) {
		this.movie_ID = movie_ID;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}
