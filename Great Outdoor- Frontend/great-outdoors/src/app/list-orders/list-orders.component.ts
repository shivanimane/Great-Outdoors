import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';
import { OrderModel} from '../models/order.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.css']
})
export class ListOrdersComponent implements OnInit {

  order:OrderModel[]=[];
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
    this.service.fetchOrder(this.id).subscribe(data => {
      this.order =data;
      console.log(this.order);
    });
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
