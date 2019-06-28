import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Flight } from './flight';
import { environment } from '../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class FlightService {

  private flightUrl = environment.baseurl+'/flights';  // URL to web api

  constructor(
    private http: HttpClient,
    ) { }

 
  
  searchFlights(flightNumber: string,origin: string,destination: string,date: string ): Observable<Flight[]> {
   
    let parameters = new HttpParams();

    if(origin){
    parameters = parameters.append('origin', origin);
    }
    if(flightNumber){
      parameters = parameters.append('flightNumber', flightNumber);
    }
    if(destination){
      parameters = parameters.append('destination', destination);
    }
    if(date){
      parameters = parameters.append('date', date);
    }
    return this.http.get<Flight[]>(`${this.flightUrl}`,{ params: parameters }).pipe(
      catchError(this.handleError<Flight[]>('searchFlights', []))
    );
  }

  



 
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); 

      return of(result as T);
    };
  }








  
}
