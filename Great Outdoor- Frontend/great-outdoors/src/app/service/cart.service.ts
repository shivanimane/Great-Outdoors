import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CartModel } from '../models/cart.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }

  addToCart(cart :CartModel){
    console.log(cart);
    return this.http.post<CartModel>("http://localhost:8006/cart/addToCart",cart);
  }
  

  fetchCart(index:String){
    console.log(index);
    return this.http.get<CartModel[]>("http://localhost:8006/cart/getAllProductsByUserId/"+index);
    
  }

}
