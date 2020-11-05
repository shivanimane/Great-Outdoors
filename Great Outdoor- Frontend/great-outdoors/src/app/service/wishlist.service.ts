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
    return this.http.post<WishlistModel>("http://localhost:8009/wishlist/addToWishlist",wishlist);
  }

  fetchWishlist(index:String){
    return this.http.get<WishlistModel[]>("http://localhost:8009/wishlist/viewWishlistByUserId/"+index);
    
  }



}
