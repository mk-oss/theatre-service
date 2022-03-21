package com.sapient.ticketing.theatreservice.api;

import java.util.List;

public interface SeatController {
	List<String> getAvailableSeatsForMovieTheatre(String movie, String theatre) throws Exception;
}
