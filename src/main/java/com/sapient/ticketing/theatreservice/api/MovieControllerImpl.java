package com.sapient.ticketing.theatreservice.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieControllerImpl implements MovieController{

	@Autowired
	private MovieRepository dao;
	@Override
	@GetMapping("/movies")
	public List<Movie> getMovies() {
		log.info("movies API");
		return dao.findAll();
	}
	
	@GetMapping("/movies/{id}")
	public Movie getTheatre(@PathVariable int id) throws Exception {
		Movie t = dao.getById(id);
		if(t==null)throw new Exception("Not Found");
		return t;
	}
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleException(Exception ex) {
		return new ExceptionResponse(new Date(), "Error", "Not found");
	}
}
