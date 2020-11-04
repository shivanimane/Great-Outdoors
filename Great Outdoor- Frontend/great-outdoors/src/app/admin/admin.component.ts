import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit(): void {
  }

  clickOnAddProductMaster(){
    this.route.navigate(['add-productMaster']);
  }

  
  clickOnViewProductMasters(){
    this.route.navigate(['list-productMasters']);
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
