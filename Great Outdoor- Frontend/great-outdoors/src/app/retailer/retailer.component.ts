import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-retailer',
  templateUrl: './retailer.component.html',
  styleUrls: ['./retailer.component.css']
})
export class RetailerComponent implements OnInit {

  id:String;
  constructor(private route : Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];
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

  clickOnAddAddress(){
    this.route.navigate(['list-address']);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }


}
