package com.flight;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.flight.entity.Flight;


@SuppressWarnings("deprecation")
@SpringBootTest
public class SearchFlightsApplicationTests {

	

@Test
public void testGetSearchFlightsListUnSuccess() throws URISyntaxException 
{
   
    RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:"+9193+"/flights/SearchFlights/Hyderabad/Mumbai/2005-05-08" ;
    URI uri = new URI(baseUrl);
 
    ResponseEntity<Flight[]> result = restTemplate.getForEntity(uri, Flight[].class);
    Flight[] res = result.getBody();
    Assertions.assertEquals(200, result.getStatusCodeValue());
    Assertions.assertNotNull(res);
}
@Test
public void testGetSearchFlightsListSuccess() throws URISyntaxException 
{
    RestTemplate restTemplate = new RestTemplate();
   
    final String baseUrl = "http://localhost:"+9193+"/flights/SearchFlights/Hyderabad/Pune/2000-05-07";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<Flight[]> result = restTemplate.getForEntity(uri, Flight[].class);
    Flight[] res = result.getBody();
    Assertions.assertEquals(200, result.getStatusCodeValue());
    Assertions.assertNotNull(res);
}
}