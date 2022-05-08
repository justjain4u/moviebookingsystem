package com.mbs.dto;

/**
 * 
 * @author vabhav.jain
 *
 */
public class MovieShowDTO implements Cloneable {

	private String showDate;

	private String showTime;

	private int bookedTickets;

	private long screenId;

	private int movieId;

	private long theatreId;

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getBookedTickets() {
		return bookedTickets;
	}

	public void setBookedTickets(int bookedTickets) {
		this.bookedTickets = bookedTickets;
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

}