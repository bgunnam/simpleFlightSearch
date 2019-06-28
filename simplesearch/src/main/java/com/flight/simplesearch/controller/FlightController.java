package com.flight.simplesearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.simplesearch.dto.Flight;
import com.flight.simplesearch.dto.SearchRequest;
import com.flight.simplesearch.dto.SearchResponse;
import com.flight.simplesearch.service.FlightService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	FlightService flightService;

	@GetMapping
	public ResponseEntity<List<Flight>> getEmployeeByID(SearchRequest searchRequest) {

		return new ResponseEntity<List<Flight>>(flightService.fetchFlights(searchRequest), HttpStatus.OK);
	}

}
