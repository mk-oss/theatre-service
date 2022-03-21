package com.sapient.ticketing.theatreservice.api;

import java.util.List;

public interface TheatreController {
	public List<Theatre> getTheatres();
	default void log(String log) {
		System.out.println("LOG:"+log);
	}
}
