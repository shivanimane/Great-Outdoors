import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WishModel } from '../models/wish.model';
import { WishService } from '../service/wish.service';
@Component({
  selector: 'app-list-wishlist',
  templateUrl: './list-wishlist.component.html',
  styleUrls: ['./list-wishlist.component.css']
})
export class ListWishlistComponent implements OnInit {
    wishes : WishModel[]=[];
    constructor(private route : Router,
      private service:WishService
      ) { }

  ngOnInit(): void {
    
  }
  
  clickOnViewAllItems(){
    this.route.navigate(['']);
  }

  clickOnAddToWishlist(){
    this.route.navigate(['']);
  }

  clickOnDeleteProduct(){
    this.route.navigate(['']);


  }

  clickOnViewAllProductFromWishList(){
    this.route.navigate(['']);

  }


 
}



