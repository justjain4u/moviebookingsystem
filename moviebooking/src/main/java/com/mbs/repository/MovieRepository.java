package com.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbs.entity.Movie;

@Repository
public interface MovieRepository 
        extends JpaRepository<Movie, Integer> {
	
	Movie findByMovieName(String movieName);
    Movie findByMovieId(long movieId);
 
}
