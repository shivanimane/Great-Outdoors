import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-retailer',
  templateUrl: './retailer.component.html',
  styleUrls: ['./retailer.component.css']
})
export class RetailerComponent implements OnInit {

  constructor(private route : Router) { }

  ngOnInit(): void {
  }

  clickOnViewAllProducts(){
    this.route.navigate(['list-products-retailer']);
  }
 
  clickOnViewCart(){
    this.route.navigate(['list-cart']);
 }

  clickOnSeeWishlist(){
    this.route.navigate(['list-wishlist']);
  }

  clickOnSeeAllOrders(){
    this.route.navigate(['list-orders']);
  }

  clickOnAddAddress(){
    this.route.navigate(['list-address']);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }


}
