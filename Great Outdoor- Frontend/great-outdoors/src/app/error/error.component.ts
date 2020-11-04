import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
errMsg : string;
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(x=>this.errMsg=x['errMsg']);
    console.log(this.errMsg);
  }

}
