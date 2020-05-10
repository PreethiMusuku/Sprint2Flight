package com.flight.service;

import java.sql.Date;
import java.util.List;

import com.flight.entity.Flight;

public interface FlightServiceImpl {

	List<Flight> findFlight(String fromloc, String toloc, Date date1);

}
