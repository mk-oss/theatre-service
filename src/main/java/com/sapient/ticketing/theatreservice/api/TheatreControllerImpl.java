package com.sapient.ticketing.theatreservice.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TheatreControllerImpl implements TheatreController {
	@Autowired
	private TheatreRepository dao;

	@Override
	@GetMapping("/theatres")
	public List<Theatre> getTheatres() {
		log.info("get theatres");
		return dao.findAll();
	}

	@GetMapping("/theatres/{id}")
	public Theatre getTheatre(@PathVariable int id) throws Exception {
		Theatre t = dao.getById(id);
		if(t==null)throw new Exception("Not Found");
		return t;
	}
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleException(Exception ex) {
		return new ExceptionResponse(new Date(), "Error", "Not found");
	}
}
