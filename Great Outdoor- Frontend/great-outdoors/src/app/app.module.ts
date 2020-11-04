import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { RetailerComponent } from './retailer/retailer.component';
import { ProductMasterComponent } from './product-master/product-master.component'
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';

const routes : Routes = [
  {path:'login', component:LoginComponent},
  {path:'admin', component:AdminComponent,canActivate: [AuthGuard]},
  {path:'product-master', component:ProductMasterComponent,canActivate: [AuthGuard]},
  {path:'retailer', component:RetailerComponent,canActivate: [AuthGuard]},
 // {path:'admin', component:AdminComponent},
  {path:'', redirectTo:'login', pathMatch:"full"},
  {path:'*', redirectTo:'login', pathMatch:"full"},
];

@NgModule({ 
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AdminComponent,
    ProductMasterComponent,
    RetailerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
