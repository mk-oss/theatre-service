package com.sapient.ticketing.theatreservice.api;

import java.util.List;

public interface MovieController {
	public List<Movie> getMovies();
	default void log(String log) {
		System.out.println("LOG:"+log);
	}
}
