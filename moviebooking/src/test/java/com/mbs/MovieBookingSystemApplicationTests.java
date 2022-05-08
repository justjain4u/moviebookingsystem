package com.mbs;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mbs.dto.MovieShowDTO;
import com.mbs.entity.MovieShow;
import com.mbs.service.MovieShowService;

/**
 * 
 * @author vabhav.jain
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MovieBookingSystemApplicationTests {

	@Autowired
	MovieShowService movieShowService;

    @Test
    public void createmovieshow() {
        MovieShowDTO aMovieShow = new MovieShowDTO();
        aMovieShow.setBookedTickets(0);
        aMovieShow.setMovieId(1);
        aMovieShow.setScreenId(1);
        aMovieShow.setShowDate("2021-11-07");
        aMovieShow.setShowTime("12:30:20");
        aMovieShow.setTheatreId(1);
        Set<MovieShow> shows = movieShowService.getMovieShowsByMovieName("Tiger");
        assertEquals(shows.size(), 1);
    }

  
}
