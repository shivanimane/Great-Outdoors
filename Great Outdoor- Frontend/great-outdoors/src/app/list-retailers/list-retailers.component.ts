import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { AdminService } from '../service/admin.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-list-retailers',
  templateUrl: './list-retailers.component.html',
  styleUrls: ['./list-retailers.component.css']
})
export class ListRetailersComponent implements OnInit {

  
  constructor(private service : AdminService, private route : Router, private Auth: AuthService) { }
  users:UserModel[]=[];


  ngOnInit(): void {
    
    setTimeout(() => { this.reloadData() }, 100);
    if(this.reloadData()==null){
      alert("No retailers have been added yet");
    }
  }
  
  
  reloadData() {
    this.service.fetchAllRetailer().subscribe(data => {
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
