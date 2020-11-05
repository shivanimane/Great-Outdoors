import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderModel } from '../models/order.model'
import { OrderService } from '../service/order.service';
@Component({
  selector: 'app-list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.css']
})
export class ListOrdersComponent implements OnInit {
  order:OrderModel[]=[];
  constructor(private route : Router,
    private service:OrderService) { }

  ngOnInit(): void {
  }
  reloadData() {
    throw new Error('Method not implemented.');
  }

  //saveOrder(){
    //console.log(this.order);
    //this.service.placeOrder(this.order).subscribe(response=>{
   //   this.route.navigate(['']);
     
   // });
    
 // }
 // remove(index: number){
  //  var ans =confirm("Are you sure you want to delete?");
  //  if(ans){
   //   this.service.deleteOrder.subscribe(response=>{
    //     console.log(this.order);
     //    this.reloadData();
    //  });
      
  //  }
 // }

 clickOnViewOrders(){
  this.route.navigate(['']);
}
logout(){
  //localStorage.clear();
  sessionStorage.clear();
  this.route.navigate(['login']);
}



}
