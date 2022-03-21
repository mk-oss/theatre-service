package com.sapient.ticketing.theatreservice.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SeatControllerImpl implements SeatController {
	@Autowired
	SeatRepository dao;

	@Override
	@GetMapping("/seats/{movie}/{theatre}")
	public List<String> getAvailableSeatsForMovieTheatre(@PathVariable String movie, @PathVariable String theatre) throws Exception {
		List<Seat> seats = dao.findAll();
		if (seats == null || seats.isEmpty()) throw new Exception("Not Found");
		List<String> availableSeat = new ArrayList<String>();
		seats.forEach(t -> availableSeat.add(t.getShow().getTheatre().getName()+":"+ t.getSeat()));
		return availableSeat;
	}

	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleException(Exception ex) {
		return new ExceptionResponse(new Date(), "Error", "Not found");
	}
}
