import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-master',
  templateUrl: './product-master.component.html',
  styleUrls: ['./product-master.component.css']
})
export class ProductMasterComponent implements OnInit {

  userName:String;
  constructor(private route : Router,
      private router : ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.userName = this.router.snapshot.params['username'];
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
