import { Component } from '@angular/core';
import { BookService } from './service/book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Welcome to Book Management!';
  todaysDate =new Date();
  constructor(private responsiveService:BookService)
  {
    setInterval(()=>
  {
    // used to print the date
    this.todaysDate=new Date();
  },1000)
  }
}
