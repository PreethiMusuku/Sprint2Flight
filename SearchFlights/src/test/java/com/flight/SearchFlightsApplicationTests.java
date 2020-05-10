package com.flight;

import static org.junit.Assert.assertSame;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.flight.entity.Flight;

@SuppressWarnings("deprecation")
@SpringBootTest
public class SearchFlightsApplicationTests {
//	
//@Autowired
//	private FlightService flightService;
//	
//
//  @Test(expected=NullPointerException.class)
// 
//  public void searchtestsuccess() throws Exception {
//Date date=new Date(2020-05-07);
//List<Flight> data=flightService.findFlight("Hyderabad","Pune",date);
//List<Flight> result=new ArrayList<Flight>();
//result.add(new Flight(14,"Spicejet","Hyderabad","Pune",100,1700,date));
//result.add(new Flight(15,"Indigo","Hyderabad","Pune",200,2000,date));
//System.out.println("data"+result);
//assertSame(data,result);
	@Test
	public void testGetSearchFlightsListSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     Date date=new Date(2020-05-07);
	    final String baseUrl = "http://localhost:"+9193+"/flights/SearchFlights/Hyderabad/Pune/2020-05-07";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Flight[]> result = restTemplate.getForEntity(uri, Flight[].class);
	    Flight[] flights = result.getBody();
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertNotNull(flights);
	}
	@Test
	public void testGetSearchFlightsListUnsuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	    Date date=new Date(2020-05-07);
	    final String baseUrl = "http://localhost:"+9193+"/flights/SearchFlights/Hyderabad/Kerala/date";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Flight[]> result = restTemplate.getForEntity(uri, Flight[].class);
	    Assert.assertEquals(400, result.getStatusCodeValue());
	}
	}

