package com.flight.simplesearch.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight.simplesearch.dto.Flight;

@Repository
public class FlightDaoImpl implements FlightDao{

	List<Flight> flights;

	@Autowired
    ResourceLoader resourceLoader;
	
	@PostConstruct
	public void init() throws JsonParseException, JsonMappingException, IOException {
		File file =  resourceLoader.getResource("classpath:flight-sample.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		flights = mapper.readValue(file, new TypeReference<List<Flight>>() {
		});

	}

	@Override
	public List<Flight> findByFlightNumberAndDate(String flightNumber, Date date) {
		return flights.stream().filter(
				flight -> flight.getFlightNumber().equals(flightNumber) && datesAreEqual(flight.getArrival(), date))
				.collect(Collectors.toList());
	}

	@Override
	public List<Flight> findByFlightOrginAndDestinationAndDate(String origin, String destination, Date date) {
		return flights
				.stream().filter(flight -> flight.getOrigin().equals(origin)
						&& flight.getDestination().equals(destination) && datesAreEqual(flight.getArrival(), date))
				.collect(Collectors.toList());
	}

	private boolean datesAreEqual(Date date1, Date date2) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		return fmt.format(date1).equals(fmt.format(date2));
	}

}
