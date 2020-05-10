package com.flight.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightDao;
import com.flight.entity.Flight;
import com.flight.exception.InvalidDetailsException;

@Service
public class FlightService implements FlightServiceImpl{

	@Autowired
	private FlightDao flightDao;

	@Override
	public List<Flight> findFlight(String fromloc,String toloc, Date date1){
		return  flightDao.findFlight(fromloc,toloc,date1);
	}
}
	
	