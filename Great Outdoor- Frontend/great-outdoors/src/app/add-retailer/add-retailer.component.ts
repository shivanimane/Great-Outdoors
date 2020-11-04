import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { AdminService } from '../service/admin.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.css']
})
export class AddRetailerComponent implements OnInit {

  user : UserModel;
  constructor(private service : AdminService, private route : Router, private Auth: AuthService) {
    this.user = new UserModel();
   }

  ngOnInit(): void {
  }


  saveUser(){
    console.log(this.user);
    this.service.addRetailer(this.user).subscribe(response=>{
      this.route.navigate(['list-retailers']);
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


