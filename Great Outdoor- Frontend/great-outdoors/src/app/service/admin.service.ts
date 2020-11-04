import { Injectable } from '@angular/core';
import { UserModel } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }


  addProductMaster(user :UserModel){
    console.log(user);
    return this.http.post<UserModel>("http://localhost:8007/admin/addProductMaster",user);
  }
  
  addRetailer(user :UserModel){
    console.log(user);
    return this.http.post<UserModel>("http://localhost:8007/admin/addRetailer",user);
  }
  
  fetchAllProductMaster(){
      return this.http.get<UserModel[]>("http://localhost:8007/admin/viewProductMaster");
  }

  fetchAllRetailer(){
    return this.http.get<UserModel[]>("http://localhost:8007/admin/viewRetailers");
  }}
