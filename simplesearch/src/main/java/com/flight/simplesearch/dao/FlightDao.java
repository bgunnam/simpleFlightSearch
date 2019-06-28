package com.flight.simplesearch.dao;

import java.util.Date;
import java.util.List;

import com.flight.simplesearch.dto.Flight;

public interface FlightDao {

	List<Flight> findByFlightNumberAndDate(String flightNumber, Date date);

	List<Flight> findByFlightOrginAndDestinationAndDate(String origin, String destination, Date date);

}
