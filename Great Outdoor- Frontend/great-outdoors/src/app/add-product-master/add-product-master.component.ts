import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { AdminService } from '../service/admin.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-add-product-master',
  templateUrl: './add-product-master.component.html',
  styleUrls: ['./add-product-master.component.css']
})
export class AddProductMasterComponent implements OnInit {

  user : UserModel;
  constructor(private service : AdminService, private route : Router, private Auth: AuthService) {
    this.user = new UserModel();
   }

  ngOnInit(): void {
  }


  saveUser(){
    console.log(this.user);
    this.service.addProductMaster(this.user).subscribe(response=>{
      this.route.navigate(['list-product-masters']);
      this.Auth.setLoggedIn(true);
    });
    
  }

 
  clickOnViewProductMasters(){
    this.route.navigate(['list-product-masters']);
  }

  clickOnAddProductMaster(){
    this.route.navigate(['add-product-master']);
  }

  clickOnViewRetailers(){
    this.route.navigate(['list-retailers']);
  }

  clickOnAddRetailers(){
    this.route.navigate(['add-retailer']);
  }
  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

}

