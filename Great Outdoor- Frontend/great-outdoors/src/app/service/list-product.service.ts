import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ListProductService {

  constructor(private http:HttpClient) { }


  fetchAllProducts(){
    return this.http.get<ProductModel[]>("http://localhost:8003/product/viewAllProducts");
  }
}
