package com.flight.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.flight.entity.Flight;
import com.flight.exception.InvalidDetailsException;
import com.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins="http://localhost:4200")
public class MyController {
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/SearchFlights/{fromloc}/{toloc}/{date1}")
	public List<Flight> findFlight(@PathVariable String fromloc,@PathVariable String toloc,@PathVariable Date date1) throws InvalidDetailsException{
		List<Flight> flight= flightService.findFlight(fromloc,toloc,date1);
		if(flight==null)
		{
			throw new InvalidDetailsException("No flights found");
		}
		else
		{
            return flight;
		}
		}


	}