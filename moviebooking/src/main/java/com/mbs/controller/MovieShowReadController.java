package com.mbs.controller;

import java.sql.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.entity.MovieShow;
import com.mbs.exception.MovieNotFoundException;
import com.mbs.exception.MBSException;
import com.mbs.service.MovieShowService;

/**
 * 
 * @author vabhav.jain
 *
 */
@RestController
@RequestMapping("/api")
public class MovieShowReadController {
	@Autowired
	MovieShowService movieShowService;

	@GetMapping("/movieshowsbycitynamedate/{city}/{movie_name}/{date}")
	public ResponseEntity<Set<MovieShow>> getMovieShowsByCityNameDate(@PathVariable String city, @PathVariable String movie_name,
			@PathVariable Date date) throws MBSException {

		Set<MovieShow> movieShows = null;
		try {
			movieShows = movieShowService.getMovieShowsByCityNameDate(city, movie_name, new java.sql.Date(date.getTime()));
			if (movieShows == null) {
				throw new MovieNotFoundException(movie_name);
			}
		}

		catch (Exception e) {
			throw new MBSException("Something wrong while retreiving the Movie Shows List");
		}
		return new ResponseEntity<Set<MovieShow>>(movieShows, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/movieshowsbyname/{movie_name}")
	public ResponseEntity<Set<MovieShow>> getMovieShowsByMovieName(@PathVariable String movie_name)
			throws MBSException {

		Set<MovieShow> movieShows = null;
		try {
			movieShows = movieShowService.getMovieShowsByMovieName(movie_name);
			if (movieShows == null) {
				throw new MovieNotFoundException(movie_name);
			}
		}

		catch (Exception e) {
			throw new MBSException("Something wrong while retreiving the Movie Shows List");
		}
		return new ResponseEntity<Set<MovieShow>>(movieShows, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/movieshowsbydate/{date}")
	public ResponseEntity<Set<MovieShow>> getMovieShowsByDate(@PathVariable Date date) throws MBSException {

		Set<MovieShow> movieShows = null;
		try {
			movieShows = movieShowService.getMovieShowsByDate(new java.sql.Date(date.getTime()));
			if (movieShows == null) {
				throw new MovieNotFoundException(date.toString());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new MBSException("Something wrong while retreiving the Movie Shows List");
		}
		return new ResponseEntity<Set<MovieShow>>(movieShows, new HttpHeaders(), HttpStatus.OK);
	}

}