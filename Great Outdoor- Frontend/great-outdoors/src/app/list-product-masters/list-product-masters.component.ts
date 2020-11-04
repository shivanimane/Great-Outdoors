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
  }
  
  
  reloadData() {
    this.service.fetchAllProductMaster().subscribe(data => {
      this.users =data;
      console.log(this.users);
    });
  }

  clickOnViewProductMasters(){
    this.route.navigate(['list-product-master']);
  }

  clickOnAddProductMaster(){
    this.route.navigate(['add-product-master']);
  }

  logout(){
    //localStorage.clear();
    sessionStorage.clear();
    this.route.navigate(['login']);
  }

  

}
