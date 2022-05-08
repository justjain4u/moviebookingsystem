package com.mbs.service;

import java.util.Set;
import java.sql.Date;
import java.text.ParseException;

import com.mbs.dto.MovieShowDTO;
import com.mbs.entity.MovieShow;

/**
 * 
 * @author vabhav.jain
 *
 */
public interface MovieShowService {

	//Read Operations
	public Set<MovieShow> getMovieShowsByMovieName(String movieName);
	public Set<MovieShow> getMovieShowsByDate(Date date);
	public Set<MovieShow> getMovieShowsByCityNameDate(String city,String movieName, Date date);
	// Create, Update and Delete Operations
	public MovieShow updateMovieShow(long showId, MovieShowDTO movieShowData) throws ParseException;
	public MovieShow createMovieShow(MovieShowDTO movieShowData) throws ParseException;
	public void deleteMovieShow(long showId);

}
