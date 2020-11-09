import { ErrorHandler, Injectable, Injector} from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable()
export class GlobalErrorService implements ErrorHandler{
  errMsg: string; 


  constructor(private injector : Injector) { }

  handleError(error: any) { 
    const router = this.injector.get(Router);
    console.log(`Request URL: ${router.url}`);

    if (error instanceof HttpErrorResponse) {
      // The backend returned an unsuccessful response code
      console.error('Backend returned status code:', error.status);
      console.error('Response body:', error.message);
      this.errMsg = error.message;
      router.navigate(['error',this.errMsg]);
    } else {
      // A client-side or network error occurred
      console.error('An error occurred:', error.message);
      this.errMsg = error.message;
      
    }

    
  }
}
