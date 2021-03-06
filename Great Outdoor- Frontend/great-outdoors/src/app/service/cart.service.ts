import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CartModel } from '../models/cart.model';
import { OrderModel } from '../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }

  addToCart(cart :CartModel){
    console.log(cart);
    return this.http.post<CartModel>("http://localhost:8006/cart/addToCart",cart).subscribe();
  }
  

  fetchCart(index:String){
    console.log(index);
    return this.http.get<CartModel[]>("http://localhost:8006/cart/getAllProductsByUserId/"+index);
    
  }
  deleteProductFromCart(userId:String,productId:String){
    console.log(userId,productId);
    return this.http.delete("http://localhost:8006/cart/removeProductByUserIdProductId/"+userId +"/" +productId);
  }

  fetchOrder(index:String){
    console.log(index);
    return this.http.get<OrderModel[]>("http://localhost:8006/order/getAllOrdersByUserId/"+index);
    
  }

  cancelOrder(orderId:String){
    console.log(orderId);
    return this.http.delete("http://localhost:8006/order/cancelOrder/"+orderId  );
    
  }

}
