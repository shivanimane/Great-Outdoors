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
import { ListProductComponent } from './list-product/list-product.component';
import { AddRetailerComponent } from './add-retailer/add-retailer.component';
import { AddProductMasterComponent } from './add-product-master/add-product-master.component';
import { ListRetailersComponent } from './list-retailers/list-retailers.component';
import { ListProductMastersComponent } from './list-product-masters/list-product-masters.component';
import { ListProductsRetailerComponent } from './list-products-retailer/list-products-retailer.component';
import { ListCartComponent } from './list-cart/list-cart.component';
import { ListWishlistComponent } from './list-wishlist/list-wishlist.component';
import { ListOrdersComponent } from './list-orders/list-orders.component';
import { ErrorComponent } from './error/error.component';

const routes : Routes = [
  {path:'login', component:LoginComponent},
  {path:'admin', component:AdminComponent,canActivate: [AuthGuard]},
  {path:'product-master', component:ProductMasterComponent,canActivate: [AuthGuard]},
  {path:'retailer', component:RetailerComponent,canActivate: [AuthGuard]},
  {path:'list-product',component:ListProductComponent},
  {path:'list-product-masters',component:ListProductMastersComponent},
  {path:'list-retailers',component:ListRetailersComponent},
  {path:'add-product-master',component:AddProductMasterComponent},
  {path:'add-retailer',component:AddRetailerComponent},
  {path:'list-products-retailer', component:ListProductsRetailerComponent},
  {path:'list-cart', component:ListCartComponent},
  {path:'list-wishlist', component:ListWishlistComponent},
  {path:'list-orders', component:ListOrdersComponent},
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
    RetailerComponent,
    ListProductComponent,
    AddRetailerComponent,
    AddProductMasterComponent,
    ListRetailersComponent,
    ListProductMastersComponent,
    ListProductsRetailerComponent,
    ListCartComponent,
    ListWishlistComponent,
    ListOrdersComponent,
    ErrorComponent
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
