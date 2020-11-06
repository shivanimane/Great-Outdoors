import { Component, OnInit } from '@angular/core';

import { CartService } from '../service/cart.service';
import { CartModel } from '../models/cart.model'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-cart',
  templateUrl: './list-cart.component.html',
  styleUrls: ['./list-cart.component.css']
})
export class ListCartComponent implements OnInit {

  cart:CartModel[]=[];
  id:String;

  constructor(private route : Router,
    private service:CartService,private activatedRoute:ActivatedRoute
    ) { 
    }

  ngOnInit(): void {
    
    
    this.id=this.activatedRoute.snapshot.params['id'];
    setTimeout(() => { this.reloadData() }, 100);
  }
  
  
  reloadData() {
    this.service.fetchCart(this.id).subscribe(data => {
      this.cart =data;
      console.log(this.cart);
    });
  }

  placeOrder(userId:String,addressId:String,totalCost:number){
  //   console.log(this.id);
  //   userId=this.id;
  //   addressId="123";
  //   totalCost=340;
   
  //   this.service.placeOrder(userId,addressId,totalCost);
    
  //   this.route.navigate(['list-order',this.id]);
   }

deleteFromCart(productId:string) {
  
  var ans =confirm("Are you sure you want to delete?");
  if(ans){
    this.service.deleteProductFromCart(this.id,productId).subscribe(response=>{
       console.log(this.cart);
       this.reloadData();
    });
}
}
  clickOnViewAllProducts(){
    this.route.navigate(['list-products-retailer',this.id]);
  }
 
  clickOnViewCart(){
    this.route.navigate(['list-cart',this.id]);
 }

  clickOnSeeWishlist(){
    this.route.navigate(['list-wishlist',this.id]);
  }

  clickOnSeeAllOrders(){
    this.route.navigate(['list-orders',this.id]);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
