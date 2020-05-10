package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entity.Register;

@Repository
public interface FlightDao extends JpaRepository<Register, Integer> {


	public Register findByMailid(String reg);
	}

