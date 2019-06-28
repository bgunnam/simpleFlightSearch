import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';


import { AppRoutingModule }     from './app-routing.module';

import { AppComponent }         from './app.component';
import { FlightSearchComponent }  from './flight-search/flight-search.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
 ],
  declarations: [
    AppComponent,
    FlightSearchComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
