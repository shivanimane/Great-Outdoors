import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CartModel } from '../models/cart.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }
  fetchCart(index:String){
    console.log(index);
    return this.http.get<CartModel[]>("http://localhost:8009/wishlist/viewWishlistByUserId/"+index);
    
  }

}
