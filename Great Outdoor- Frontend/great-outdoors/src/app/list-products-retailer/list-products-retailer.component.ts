import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartModel } from '../models/cart.model';
import { ProductModel } from '../models/product.model';
import { WishlistModel } from '../models/wishlist.model';
import { CartService } from '../service/cart.service';
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
  cart:CartModel=new CartModel();
  

  id:String;

  constructor(private route : Router,
    private activatedRoute :ActivatedRoute,
    private service:WishlistService,
    private productService:ProductService,
    private cartService:CartService
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

  addToCart(productId:String){
    console.log(this.id);
    this.cart.retailerId=this.id;
    this.cart.productId=productId;
    console.log(this.cart);
    this.cartService.addToCart(this.cart);
    this.route.navigate(['list-cart',this.id]);
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
