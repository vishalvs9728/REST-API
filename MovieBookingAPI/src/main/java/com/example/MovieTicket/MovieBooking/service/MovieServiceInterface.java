package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import jakarta.validation.Valid;

public interface MovieServiceInterface {

	List<Movie> getAllMovies();
	
	void addMovie(@Valid Movie movie);

	Movie getMovie(String id);

	void deleteMovie(String id);

	void updateMovieDetail(@Valid Movie topic, String id);

}
