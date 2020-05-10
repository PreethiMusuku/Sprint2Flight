package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.Register;
import com.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins="http://localhost:4200")
public class MyController {
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/RegPage")
	public String register(@RequestBody Register reg){
		Register user1 = flightService.findOne(reg.getMailid());
		 if (user1!=null)
		    {
			 return "User exists with same MailId!!";
		    }
		    else {

		    	 flightService.register(reg);

		    }

		
		return "Registered successfully";
	}
}
