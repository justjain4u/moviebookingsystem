package com.mbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.dto.MovieShowDTO;
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
public class MovieShowWriteController {
	@Autowired
	MovieShowService movieShowService;

	@PostMapping("/createmovieshow")
	public ResponseEntity<MovieShow> createMovieShow(@RequestBody MovieShowDTO movieShowData) {
		MovieShow movieShow = null;
		try {
			movieShow = movieShowService.createMovieShow(movieShowData);
			if (movieShow == null) {
				throw new MovieNotFoundException("");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new MBSException("Something wrong while creating a the Movie Show");
		}
		return new ResponseEntity<MovieShow>(movieShow, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/updatemovieshow/{show_id}")
	public ResponseEntity<MovieShow> updateMovieShow(@PathVariable("show_id") long show_id,
			@RequestBody MovieShowDTO movieShowData) {
		MovieShow movieShows = null;
		try {
			movieShows = movieShowService.updateMovieShow(show_id, movieShowData);
			if (movieShows == null) {
				throw new MovieNotFoundException("");
			}
		}

		catch (Exception e) {
			throw new MBSException("Something wrong while updating a Movie Show");
		}
		return new ResponseEntity<MovieShow>(movieShows, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/deletemovieshow/{show_id}")
	public ResponseEntity<HttpStatus> deleteMovieShow(@PathVariable("show_id") long show_id) {
		try {
			movieShowService.deleteMovieShow(show_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new MBSException("Something wrong while deleting a Movie Show");
		}
	}

}