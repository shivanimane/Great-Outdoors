import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { WishlistModel } from '../models/wishlist.model';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  constructor(private http:HttpClient) { }


  addToWishlist(wishlist :WishlistModel){
    console.log(wishlist);
    return this.http.post<WishlistModel>("http://localhost:8003/wishlist/addToWishlist",wishlist);
  }

  fetchWishlist(index:String){
    console.log(index);
    return this.http.get<WishlistModel[]>("http://localhost:8006/cart/getAllProductsByUserId/"+index);
    
  }

}
