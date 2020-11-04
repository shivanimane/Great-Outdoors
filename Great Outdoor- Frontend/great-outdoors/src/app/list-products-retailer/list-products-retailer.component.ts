import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductModel } from '../models/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-list-products-retailer',
  templateUrl: './list-products-retailer.component.html',
  styleUrls: ['./list-products-retailer.component.css']
})
export class ListProductsRetailerComponent implements OnInit {

  products:ProductModel[]=[];

  constructor(private route : Router,
    private service:ProductService
    ) { 

    }

  ngOnInit(): void {
    
    setTimeout(() => { this.reloadData() }, 100);
  }
  
  
  reloadData() {
    this.service.fetchAllProducts().subscribe(data => {
      this.products =data;
      console.log(this.products);
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
    this.route.navigate(['list-cart']);
 }

  clickOnSeeWishlist(){
    this.route.navigate(['list-wishlist']);
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
