import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductModel } from '../models/product.model';
import { WishlistModel } from '../models/wishlist.model';
import { ProductService } from '../service/product.service';
import { WishlistService } from '../service/wishlist.service';

@Component({
  selector: 'app-list-products-retailer',
  templateUrl: './list-products-retailer.component.html',
  styleUrls: ['./list-products-retailer.component.css']
})
export class ListProductsRetailerComponent implements OnInit {

  products:ProductModel[]=[];
  wishlist: WishlistModel= new WishlistModel();
  

  id:String;

  constructor(private route : Router,
    private activatedRoute :ActivatedRoute,
    private service:WishlistService,
    private productService:ProductService
    ) { 

    }

  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];
    setTimeout(() => { this.reloadData() }, 100);
    
  }
  
  
  reloadData() {
    this.productService.fetchAllProducts().subscribe(data => {
      this.products =data;
      console.log(this.products);
    });
  }

  addToCart(index:number){

  }

  addToWishlist(productId:String,productName:String,price:Number){
    console.log(this.id);
    this.wishlist.userId=this.id;
    this.wishlist.productId=productId;
    this.wishlist.productName=productName;
    this.wishlist.price=price;
    console.log(this.wishlist);
    this.service.addToWishlist(this.wishlist);
    this.route.navigate(['list-wishlist',this.id]);
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
    this.route.navigate(['list-orders']);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}
