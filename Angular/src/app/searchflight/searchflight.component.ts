import { Component, OnInit } from '@angular/core';
import {  UserFlightService, Flight } from '../user-flight.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-searchflight',
  templateUrl: './searchflight.component.html',
  styleUrls: ['./searchflight.component.css']
})
export class SearchflightComponent implements OnInit {
 searchs: Flight[];
  valid: any;
  message: any;
  error: boolean;
result:any;
  constructor(private service: UserFlightService) { 
  }
  onSubmit(SearchFlight:Flight) {
console.log(SearchFlight);
this.valid = this.validation(SearchFlight.fromloc,SearchFlight.toloc,SearchFlight.date1);
if(this.valid)
    this.service.getSearchFlights(SearchFlight).subscribe(
      response => this.handleSuccessfulResponse(response),
      error=>{console.log("exception occured" );
    this.result="FlightNumber not exists";}
    );

  }
  handleSuccessfulResponse(response) {
    this.searchs = response;
    console.log(this.searchs);
    
  }

  ngOnInit() {
  }
  validation(fromloc: any, toloc: any,date1:any): any {
    this.valid = true;
    this.message='';
    if(fromloc =='' || toloc =='' || date1 ==''){
      this.error=true;
      this.message='Fill all the fields!!';
      this.valid = false;
    }
    return this.valid;
}
}

