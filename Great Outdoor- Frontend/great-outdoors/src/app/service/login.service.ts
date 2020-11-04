import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/login.model';
import { UserModel } from '../models/user.model';
@Injectable({
    providedIn: 'root'
  })
export class LoginService{
    
  loginList : Login[] = [];
  

  constructor(public http : HttpClient) {
    
    
   }

   loginUser(login : Login){
     console.log(login);
     return this.http.post<UserModel>("http://localhost:8007/login/loginUser",login);
   }

}