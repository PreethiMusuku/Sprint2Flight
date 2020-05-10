package com.flight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.flight.dao.FlightDao;
import com.flight.entity.Register;
import com.flight.service.FlightService;

import junit.framework.Assert;

@SpringBootTest
public class RegistrationApplicationTests {
	@SuppressWarnings("deprecation")
	@Test
	public void registrationsuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:"+ 9194 + "/flights/RegPage" ;
	    URI uri = new URI(baseUrl);
	 Register register=new Register(20,"soum","Soumya128","Soumya128","ok@gmail.com","9876564431");
	 
	 HttpHeaders headers=new HttpHeaders();
	 headers.set("X-COM-PERSIST","Registered successfully");
	 HttpEntity<Register> request=new HttpEntity<>(register, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri,request, String.class);
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertNotNull(register);
	}

}
