import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';

import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: [ './flight-search.component.css' ]
})
export class FlightSearchComponent implements OnInit {
  flights: Observable<Flight[]>;
  private searchTerms = new Subject<string>();

  flightNumber: string='';
  origin: string='';
  destination: string='';
  date: string='';

  error:boolean;
  errorMessage: string;

  constructor(private flightService: FlightService) {}

  search(): void {

    this.error= false;
    if(!this.flightNumber && !this.origin){
      this.error = true;
      this.errorMessage = "Flight Number or (Origin and Destination is Required)"
      return;
    }

    if(this.origin && !this.destination){
      this.error = true;
      this.errorMessage = "Destination is required when origin is given."
      return;
    }

    if(!this.date){
      this.error = true;
      this.errorMessage  ="Date is required";
      return;
    }



    this.flights =this.flightService.searchFlights(this.flightNumber,this.origin,this.destination,this.date);



  }
 

  ngOnInit(): void {
 
  }
}
