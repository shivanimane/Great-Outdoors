import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor( private route : Router, private Auth: AuthService) { }

  ngOnInit(): void {
  }

  clickOnAddProductMaster(){
    this.route.navigate(['add-product-master']);
  }

  
  clickOnViewProductMasters(){
    this.route.navigate(['list-product-masters']);
  }

  clickOnAddRetailer(){
    this.route.navigate(['add-retailer']);
  }

  
  clickOnViewRetailers(){
    this.route.navigate(['list-retailers']);
  }

  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }


}
