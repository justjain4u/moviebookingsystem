package com.mbs.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mbs.dto.MovieShowDTO;
import com.mbs.entity.Movie;
import com.mbs.entity.MovieShow;
import com.mbs.entity.Screen;
import com.mbs.entity.Theatre;
import com.mbs.exception.MBSException;
import com.mbs.repository.MovieRepository;
import com.mbs.repository.MovieShowRepository;
import com.mbs.repository.ScreenRepository;
import com.mbs.repository.TheatreRepository;
/**
 * 
 * @author vabhav.jain
 *
 */
@Service
public class MovieShowServiceImpl implements MovieShowService {
	@Autowired
	private MovieShowRepository movieShowRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public Set<MovieShow> getMovieShowsByMovieName(String movieName) {

		Movie movie = movieRepository.findByMovieName(movieName);
		Set<MovieShow> movieShows = this.movieShowRepository.findMovieShowsByMovieName(movie.getMovieId());
		return movieShows;
	}

	@Override
	@Cacheable(value="MovieShow", key="#date")
	public Set<MovieShow> getMovieShowsByDate(Date date) {
		Set<MovieShow> movieShows = this.movieShowRepository.findMovieShowsByDate(date);
		return movieShows;
	}

	@Override
	public Set<MovieShow> getMovieShowsByCityNameDate(String city, String movieName, Date date) {
		Set<MovieShow> movieShows = this.movieShowRepository.findMovieShows(city.toLowerCase(), movieName.toLowerCase(),
				date);
		return movieShows;
	}

	@Override
	public MovieShow updateMovieShow(long showId, MovieShowDTO movieShowData) throws ParseException {
		MovieShow movieShowNew = null;
		Optional<MovieShow> movieShow = movieShowRepository.findById(showId);

		if (movieShow.isPresent()) {
			MovieShow movieShowFromDB = movieShow.get();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(movieShowData.getShowDate());
			movieShowFromDB.setShowDate(new java.sql.Date(date.getTime()));
			movieShowFromDB.setShowTime(java.sql.Time.valueOf(movieShowData.getShowTime()));
			movieShowNew = this.movieShowRepository.save(movieShowFromDB);
		}
		return movieShowNew;
	}

	@Override
	public void deleteMovieShow(long showId) {
		this.movieShowRepository.deleteById(showId);
	}

	@Override
	public MovieShow createMovieShow(MovieShowDTO movieShowData) throws ParseException {
		MovieShow movieShowNew = null;
		MovieShow movieShow = new MovieShow();

		Optional<Theatre> threatreData = theatreRepository.findById(movieShowData.getTheatreId());
		if (threatreData.isPresent()) {
			Optional<Screen> screenData = screenRepository.findById(movieShowData.getScreenId());
			if (screenData.isPresent()) {
				Optional<Movie> movieData = movieRepository.findById(movieShowData.getMovieId());
				if (movieData.isPresent()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = sdf.parse(movieShowData.getShowDate());
					movieShow.setShowDate(new java.sql.Date(date.getTime()));
					movieShow.setShowTime(java.sql.Time.valueOf(movieShowData.getShowTime()));
					movieShow.setScreen(screenData.get());
					movieShow.setMovie(movieData.get());
					movieShow.setBookedTickets(movieShowData.getBookedTickets());
					movieShowNew = this.movieShowRepository.save(movieShow);
				} else {
					throw new MBSException("Movie id is invalid");
				}
			} else {
				throw new MBSException("Screen id is invalid");
			}
		} else {
			throw new MBSException("Theatre id is invalid");
		}
		return movieShowNew;
	}

}
