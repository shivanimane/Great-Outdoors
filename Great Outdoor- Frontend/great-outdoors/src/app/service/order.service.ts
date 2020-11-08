import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { OrderModel } from '../models/order.model';



@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
 
  deleteOrder(index : number){
    console.log(index);
    return this.http.delete("http://localhost:8006/cart/removeProductByUserIdProductId/"+index);

  }
  public placeOrder(userId:string,addressId:string,totalCost:number){
    console.log("In service");
    let body = new HttpParams();
    body = body.set('userId', userId);
    body = body.set('addressId', addressId);
    body = body.set('totalCost', ""+totalCost);
    return this.http.post("http://localhost:8006/cart/placeOrder",body,{responseType:'text' as 'json'});
  }





}
