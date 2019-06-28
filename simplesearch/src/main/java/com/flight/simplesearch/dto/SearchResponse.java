package com.flight.simplesearch.dto;

import java.util.List;

public class SearchResponse {

	private List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
