package com.mbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable{
    @Id
    @Column(name = "MOVIE_ID")
    private Integer movieId;
    
    @Column(name = "MOVIE_NAME")
    private String movieName;
    
    @Column(name = "MOVIE_POSTER_URL")
    private String moviePosterUrl;
    
    @Column(name = "MOVIE_TAGS")
    private String movieTags;

    public String getMovieTags() {
        return movieTags;
    }

    public void setMovieTags(String movieTags) {
        this.movieTags = movieTags;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }
}