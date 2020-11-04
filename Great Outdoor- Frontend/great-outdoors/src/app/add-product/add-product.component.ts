import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductModel } from '../models/product.model';
import { AuthService } from '../service/auth.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product : ProductModel;
  constructor(private service : ProductService, private route : Router, private Auth: AuthService) {
    this.product = new ProductModel();
   }

  ngOnInit(): void {
  }


  saveProduct(){
    console.log(this.product);
    this.service.addProduct(this.product).subscribe(response=>{
      this.route.navigate(['list-course']);
      this.Auth.setLoggedIn(true);
    });
    
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
