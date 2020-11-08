import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';
import { CartService } from '../service/cart.service';
import { CartModel } from '../models/cart.model'
import { ActivatedRoute, Router } from '@angular/router';
import { OrderModel } from '../models/order.model';

@Component({
  selector: 'app-list-cart',
  templateUrl: './list-cart.component.html',
  styleUrls: ['./list-cart.component.css']
})
export class ListCartComponent implements OnInit {

  cart:CartModel[]=[];
  id:String;
  userId:string;
  products:any;
  order:OrderModel;
  totalCost:Number=0;

  constructor(private route : Router,
    private service:CartService,private activatedRoute:ActivatedRoute,
    private orderService:OrderService
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
     this.products=data;
    });
  }

   calculateTotalCost(){
    for (var i = 0; i < this.cart.length; i++) {
      this.totalCost = this.cart[i].price;
    }
    return this.totalCost;
   }

  placeOrder(){
    
    // this.order.totalCost=this.calculateTotalCost();
    // console.log(this.totalCost);
    var addressId = "sagych";
    //var totalCost = Number(this.calculateTotalCost());
    var totalCost = 7000;
    var userId= this.id.toString();
    this.orderService.placeOrder(userId,addressId,totalCost);
    this.route.navigate(['list-orders',this.id]);
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
