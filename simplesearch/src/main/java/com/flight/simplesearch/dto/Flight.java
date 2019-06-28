
package com.flight.simplesearch.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "flightNumber", "carrier", "origin", "departure", "destination", "arrival", "aircraft", "distance",
		"travelTime", "status" })
public class Flight {

	@JsonProperty("flightNumber")
	private String flightNumber;
	@JsonProperty("carrier")
	private String carrier;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("departure")
	private Date departure;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("arrival")
	private Date arrival;
	@JsonProperty("aircraft")
	private String aircraft;
	@JsonProperty("distance")
	private Integer distance;
	@JsonProperty("travelTime")
	private String travelTime;
	@JsonProperty("status")
	private String status;

	@JsonProperty("flightNumber")
	public String getFlightNumber() {
		return flightNumber;
	}

	@JsonProperty("flightNumber")
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@JsonProperty("carrier")
	public String getCarrier() {
		return carrier;
	}

	@JsonProperty("carrier")
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@JsonProperty("departure")
	public Date getDeparture() {
		return departure;
	}

	@JsonProperty("departure")
	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}

	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@JsonProperty("arrival")
	public Date getArrival() {
		return arrival;
	}

	@JsonProperty("arrival")
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	@JsonProperty("aircraft")
	public String getAircraft() {
		return aircraft;
	}

	@JsonProperty("aircraft")
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	@JsonProperty("distance")
	public Integer getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@JsonProperty("travelTime")
	public String getTravelTime() {
		return travelTime;
	}

	@JsonProperty("travelTime")
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

}