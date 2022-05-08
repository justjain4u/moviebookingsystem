package com.mbs.repository;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mbs.entity.MovieShow;

/**
 * 
 * @author vabhav.jain
 *
 */
@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

	@Query("SELECT m FROM MovieShow m, Movie mv WHERE m.movie.movieId = mv.movieId AND m.movie.movieId = :movieId")
	Set<MovieShow> findMovieShowsByMovieName(@Param(value="movieId") Integer movieId);
	
	@Query("SELECT m FROM MovieShow m WHERE m.showDate = :date")
	Set<MovieShow> findMovieShowsByDate(@Param(value="date") Date date);
	
	@Query("SELECT m FROM MovieShow m, Movie mv,Screen sc,Theatre tr WHERE m.movie.movieId = mv.movieId "
			+ "AND m.screen.screenId = sc.screenId AND sc.theatre.theatreId = tr.theatreId "
			+ "AND lower(m.movie.movieName) = :name AND lower(m.screen.theatre.theatreCity) = :city AND m.showDate = :date")
	Set<MovieShow> findMovieShows(@Param(value="city") String city, @Param(value="name") String name, @Param(value="date") Date date);
}