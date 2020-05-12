package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightDao;
import com.flight.entity.Register;

@Service
public class FlightService implements FlightServiceImpl{

	@Autowired
	private FlightDao flightDao;
	@Override
	public Register register(Register reg) {
	return flightDao.save(reg);

	}

	  public Register findOne(String reg) {
		return flightDao.findByMailid(reg);
	}
}