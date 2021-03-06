import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../models/user.model';
import { Login } from '../models/login.model';
import { LoginService } from '../service/login.service';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login: Login;
  user: UserModel;
  id: String;
  userName:String;
  msg:String;

  constructor(private route: Router, 
    private loginservice: LoginService,
    private Auth: AuthService
     ) {
 
    this.login = new Login();
    this.user = new UserModel();
  }

  ngOnInit() {

  }



  checkRole(user: UserModel) {

    if (user == null) {
      alert("Invalid Username and Password");
    }

    //localStorage.setItem('user',this.employee.employeeId);
    sessionStorage.setItem('user', this.user.id);
    sessionStorage.setItem('username',this.user.username);
    console.log(user.role);

    if (user.role == "admin") {
      this.route.navigate(['admin',user.username]);
      this.Auth.setLoggedIn(true);
    } else if (user.role == "retailer") {
      this.route.navigate(['retailer',user.id,user.username]);
      this.Auth.setLoggedIn(true);
    } else if (user.role == "product master") {
      this.route.navigate(['product-master',user.username]);
      this.Auth.setLoggedIn(true);
    } else {
      
      alert("You are not registered!")
    }

    

  }
  checkLogin() {
    console.log(this.login);
   this.loginservice.loginUser(this.login).subscribe(data => {
   this.user = data;
      this.checkRole(this.user);
      console.log(this.user);
    
    },
    error=>{
      alert("Please enter correct credentials!!")
      console.log("exception occured")
     
  });
    
  }
}
