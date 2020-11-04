import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListProductService } from '../service/list-product.service';
import { ProductModel } from '../models/product.model'

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

products:ProductModel[]=[];

  constructor(private route : Router,
    private service:ListProductService
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

  clickOnViewProducts(){
    this.route.navigate(['list-product']);
  }

  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }
}
