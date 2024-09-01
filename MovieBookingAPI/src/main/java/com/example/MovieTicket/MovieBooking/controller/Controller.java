package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class Controller {

	@Autowired
	MovieServiceInterface movieServie;

	@GetMapping("movies")
	public List<Movie> getAllMovies() {
		return movieServie.getAllMovies();
	}

	@PostMapping("/movie")
	public void addMoview(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("Invalid data");
		}
		movieServie.addMovie(movie);

	}

	@GetMapping("movie/{id}")
	public Movie getMovie(@PathVariable String id) {
		return movieServie.getMovie(id);
	}

	@DeleteMapping("movie/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieServie.deleteMovie(id);
	}

	@PutMapping("update/{id}")
	public void updateMovieDetail(@Valid @RequestBody Movie topic, @PathVariable String id,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("Invalid data");
		}
		movieServie.updateMovieDetail(topic, id);
	}

}
