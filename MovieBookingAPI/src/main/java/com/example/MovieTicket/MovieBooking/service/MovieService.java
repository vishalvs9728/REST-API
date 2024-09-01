package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExistException;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFoundException;
import com.example.MovieTicket.MovieBooking.Model.Movie;

@Service
public class MovieService implements MovieServiceInterface {

	private List<Movie> movieList = new ArrayList<Movie>();
	private Map<String, Movie> movieMap = new HashMap<>();

	@Override
	public List<Movie> getAllMovies() {
		return movieList;
	}

	@Override
	public void addMovie(Movie movie) {
		if (movieMap.containsKey(movie.getId())) {
			throw new IdAlreadyExistException("ID Already Exist: " + movie.getId());
		}
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);

	}

	@Override
	public Movie getMovie(String id) {
		if (!movieMap.containsKey(id)) {
			throw new IdNotFoundException("Given Id " + id + " not found");
		}
		return movieMap.get(id);
	}

	@Override
	public void deleteMovie(String id) {
		if (!movieMap.containsKey(id)) {
			throw new IdNotFoundException("Given Id " + id + " not found");
		}
		Movie deleteMovie = movieMap.get(id);
		movieList.remove(deleteMovie);
		movieMap.remove(id);
	}

	@Override
	public void updateMovieDetail(Movie topic, String id) {
		if (!movieMap.containsKey(id)) {
			throw new IdNotFoundException("Given Id " + id + " not found");
		}
		Movie deleteMovie = movieMap.get(id);
		movieList.remove(deleteMovie);
		movieMap.put(id, topic);
		movieList.add(topic);

	}

}
