import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModel } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http:HttpClient) { }



  
  fetchAllProductMaster(){
      return this.http.get<UserModel[]>("http://localhost:8007/admin/viewProductMaster");
  }

  fetchAllRetailer(){
    return this.http.get<UserModel[]>("http://localhost:8007/admin/viewRetailers");
  }
  

}
