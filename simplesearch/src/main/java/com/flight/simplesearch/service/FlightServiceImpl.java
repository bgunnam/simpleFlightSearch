package com.flight.simplesearch.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flight.simplesearch.dao.FlightDao;
import com.flight.simplesearch.dto.Flight;
import com.flight.simplesearch.dto.SearchRequest;
import com.flight.simplesearch.dto.SearchResponse;
import com.flight.simplesearch.exception.InvalidSearchRequestException;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Override
	public List<Flight> fetchFlights(SearchRequest searchRequest) {
		if (StringUtils.isEmpty(searchRequest.getFlightNumber()) && StringUtils.isEmpty(searchRequest.getOrigin())) {
			throw new InvalidSearchRequestException("Flight number or origin is required");
		}

		if (searchRequest.getDate() == null) {
			throw new InvalidSearchRequestException("Date is required");

		}
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(searchRequest.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		List<Flight> flights;
		if (!StringUtils.isEmpty(searchRequest.getFlightNumber())) {
			flights = flightDao.findByFlightNumberAndDate(searchRequest.getFlightNumber(), date1);
		} else {
			flights = flightDao.findByFlightOrginAndDestinationAndDate(searchRequest.getOrigin(),
					searchRequest.getDestination(), date1);

		}
		
		return flights;
	}

}
