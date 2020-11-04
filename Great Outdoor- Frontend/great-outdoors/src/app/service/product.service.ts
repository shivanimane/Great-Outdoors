import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }


  fetchAllProducts(){
    return this.http.get<ProductModel[]>("http://localhost:8003/product/viewAllProducts");
  }

  addProduct(product :ProductModel){
    console.log(product);
    return this.http.post<ProductModel>("http://localhost:8003/product/addProduct",product);
  }
  
  deleteProduct(index : number){
    console.log(index);
    return this.http.delete("http://localhost:8003/product/deleteProduct/"+index);
  }
}
