package com.mbs.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "MOVIESHOW")
public class MovieShow implements Cloneable, Serializable {
    @Id
    @Column(name = "MOVIESHOW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;
    
    @Column(name = "MOVIESHOW_DATE")
    private java.sql.Date showDate;
    
    @Column(name = "MOVIESHOW_TIME")
    private java.sql.Time showTime;
    
    @Column(name = "BOOKED_TICKETS")
    private int bookedTickets;
    
    @ManyToOne
    @JoinColumn(name = "SCREEN_ID")
    @JsonManagedReference
    private Screen screen;
    
	@ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    @JsonManagedReference
    private Movie movie;
    
    public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

    public int getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(int bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }
}