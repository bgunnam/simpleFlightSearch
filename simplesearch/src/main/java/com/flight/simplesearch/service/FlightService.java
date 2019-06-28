package com.flight.simplesearch.service;

import java.util.List;

import com.flight.simplesearch.dto.Flight;
import com.flight.simplesearch.dto.SearchRequest;
import com.flight.simplesearch.dto.SearchResponse;

public interface FlightService {

	public List<Flight> fetchFlights(SearchRequest searchRequest);
	
}
