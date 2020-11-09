import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WishlistModel } from '../models/wishlist.model';
import { WishlistService } from '../service/wishlist.service';
@Component({
  selector: 'app-list-wishlist',
  templateUrl: './list-wishlist.component.html',
  styleUrls: ['./list-wishlist.component.css']
})
export class ListWishlistComponent implements OnInit {

  wishlist:WishlistModel[]=[];
  id:String;

  constructor(private route : Router,
    private service:WishlistService,private activatedRoute:ActivatedRoute) { 
    }

  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];
    setTimeout(() => { this.reloadData() }, 100);
  }
  
  
  reloadData() {
    this.service.fetchWishlist(this.id).subscribe(data => {
      this.wishlist =data;
      console.log(this.wishlist);
    });
  }

  addToCart(index:number){

  }

  deleteFromWishlist(productId : String){
    
    var ans =confirm("Are you sure you want to delete?");
    if(ans){
      this.service.deleteWishlist(this.id,productId).subscribe(response=>{
         console.log(this.wishlist);
         this.reloadData();
      });
  }
  // alert("Product has been deleted from wishlist");
  // this.route.navigate(['list-wishlist']);
 
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
