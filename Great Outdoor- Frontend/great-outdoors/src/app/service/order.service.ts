import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderModel } from '../models/order.model';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
  placeOrder(order :OrderModel){
    console.log(order);
    return this.http.post<OrderModel>("http://localhost:8006/cart/placeOrder/",order);
  }

  deleteOrder(index : number){
    console.log(index);
    return this.http.delete("http://localhost:8006/cart/removeProductByUserIdProductId/"+index);

   

  }






}
