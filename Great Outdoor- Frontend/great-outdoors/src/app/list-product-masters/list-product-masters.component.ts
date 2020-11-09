import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { AuthService } from '../service/auth.service';
import { AdminService } from '../service/admin.service';
@Component({
  selector: 'app-list-product-masters',
  templateUrl: './list-product-masters.component.html',
  styleUrls: ['./list-product-masters.component.css']
})
export class ListProductMastersComponent implements OnInit {

  constructor(private service : AdminService, private route : Router, private Auth: AuthService) { }
  users:UserModel[]=[];


  ngOnInit(): void {
    
    setTimeout(() => { this.reloadData() }, 100);
    if(this.reloadData()==null){
      alert("No product masters have been added yet");
    }
  }
  
  
  reloadData() {
    this.service.fetchAllProductMaster().subscribe(data => {
      this.users =data;
      console.log(this.users);
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
