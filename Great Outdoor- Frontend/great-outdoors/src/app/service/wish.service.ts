import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { WishModel } from '../models/wish.model';

@Injectable({
  providedIn: 'root'
})
export class WishService {

  constructor(private http:HttpClient) { }

  addToWishlist(wish :WishModel){
    console.log(wish);
    return this.http.post<WishModel>("http://localhost:8009/wishlist/addToWishlist",wish);

  }
  viewAllItems(){
    return this.http.get<WishModel[]>("http://localhost:8009/wishlist/viewAll")

  }
  deleteProduct(index : number){
    console.log(index);
    return this.http.delete("http://localhost:8003/product/deleteProduct/\"+index;")
  }
  viewAllProductFromWishList(){
    return this.http.get<WishModel[]>("http://localhost:8009/wishlist/viewAllProducts");

  }
}
