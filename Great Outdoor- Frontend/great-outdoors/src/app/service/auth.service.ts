import { Injectable } from '@angular/core';
import { UserModel } from '../models/user.model';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  private loggedInStatus : boolean = false ;

  authenticate(user: UserModel) :boolean{
    if(user!=null){
      sessionStorage.setItem("userId", user.id);
      // based on type of user
      sessionStorage.setItem("usertype", user.role);

      return true;
    }else{
      return false;
    }

}
setLoggedIn(value: boolean) {
  this.loggedInStatus = value ; 
}
 
  constructor() { }

 
 public get isloggedin() : boolean {

   return this.loggedInStatus ; 
 }
 

}
