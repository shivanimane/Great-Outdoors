import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  private loggedInStatus : boolean = false ;

  setLoggedIn(value: boolean) {
    this.loggedInStatus = value ; 
  }
 
  constructor() { }

 
 public get isloggedin() : boolean {
   return this.loggedInStatus ; 
 }
 

}
