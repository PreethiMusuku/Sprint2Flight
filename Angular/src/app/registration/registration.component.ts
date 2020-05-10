import { Component, OnInit } from '@angular/core';
import { UserFlightService, Register } from '../user-flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user: Register=new Register();
  message: any;
  password:string;
  confirmpassword:string;
  constructor(private service:UserFlightService,private router:Router) { }
  ngOnInit() {
  }
  onSubmit():void{
let resp=this.service.registerNow(this.user);
resp.subscribe((data)=>this.message=data);
  }
}