package com.qa.cinema.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movie_ID;
	private String title;
	private String description;
	private String genre;
	private String duration;
	private String certification;
	private String filmImg;
	private String filmUrl;
	
//	@OneToMany
//	@JoinColumn(name="movie_ID")
//	private Set<Showing> showings = new HashSet<Showing>();

	public Movie() {

	}

	public Movie(String title, String description, String genre,
			String duration, String certification, String filmImg, String filmUrl) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.certification = certification;
		this.filmImg = filmImg;
		this.filmUrl = filmUrl;
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
	
	public String getFilmImg() {
		return filmImg;
	}

	public void setFilmImg(String filmImg) {
		this.filmImg = filmImg;
	}

	public String getFilmUrl() {
		return filmUrl;
	}

	public void setFilmUrl(String filmUrl) {
		this.filmUrl = filmUrl;
	}

}
