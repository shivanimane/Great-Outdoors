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

  addToCart(index:number){

  }

  addToWishlist(index:number){
    
  }

 
  clickOnViewAllProducts(){
    this.route.navigate(['list-products-retailer']);
  }
 
  clickOnViewCart(){
    this.route.navigate(['list-cart',this.id]);
 }

  clickOnSeeWishlist(){
    this.route.navigate(['list-wishlist',this.id]);
  }

  clickOnSeeAllOrders(){
    this.route.navigate(['list-orders']);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
