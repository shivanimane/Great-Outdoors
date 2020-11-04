import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-master',
  templateUrl: './product-master.component.html',
  styleUrls: ['./product-master.component.css']
})
export class ProductMasterComponent implements OnInit {

  constructor(private route : Router) { }

  ngOnInit(): void {
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
