import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-foreclose',
  templateUrl: './foreclose.component.html',
  styleUrls: ['./foreclose.component.css']
})
export class ForecloseComponent implements OnInit {
  constructor(private router:Router,private service:BookService) { }

  ngOnInit() {

    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }

    if(localStorage.loanid==0)
    {
      alert("You haven't applied for any loan");
      this.router.navigate(["/login"]);
    }
  }
public foreclose()
{
  // function for foreclosing the account
  console.log(localStorage.store);
  let resp4=this.service.foreclose(localStorage.store,localStorage.loanid);
  resp4.subscribe((data)=>localStorage.foreclosebalance=data);
  console.log(localStorage.foreclosebalance);
  // after foreclosing assign loanid to zero(0)
  localStorage.loanid=0;
  console.log(localStorage.loanid);
  // for printing the value to the console
  this.router.navigate(["/foreclose2"]);
}
}
