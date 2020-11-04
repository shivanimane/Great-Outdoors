import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-retailer',
  templateUrl: './retailer.component.html',
  styleUrls: ['./retailer.component.css']
})
export class RetailerComponent implements OnInit {

  constructor(private route : Router) { }

  ngOnInit(): void {
  }

}
