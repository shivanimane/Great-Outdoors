import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import { ProductModel } from '../models/product.model'

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

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

  remove(index: number){
    var ans =confirm("Are you sure you want to delete?");
    if(ans){
      this.service.deleteProduct(index).subscribe(response=>{
         console.log(this.products);
         this.reloadData();
      });
      //this.route.navigate(['list-products']);
    }
  }

  clickOnViewProducts(){
    this.route.navigate(['list-product']);
  }

  clickOnAddProduct(){
    this.route.navigate(['add-product']);
  }

  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }
}
