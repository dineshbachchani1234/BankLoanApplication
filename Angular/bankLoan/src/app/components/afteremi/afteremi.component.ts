import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/service/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-afteremi',
  templateUrl: './afteremi.component.html',
  styleUrls: ['./afteremi.component.css']
})
export class AfteremiComponent implements OnInit {
message:any;
// message to print remaining loan balance
message1:any;
// message1 to print remaining account balance
  constructor(private service:BookService,private router:Router) { }

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
  // it will help to fetch balance from the back end
public emibalance()
{
  this.message=localStorage.loan_balance;
  let resp3=this.service.emibalance(localStorage.store,localStorage.loanid);
  resp3.subscribe((data)=>
  {this.message1=data;
  },err=>
  {
    console.log(err);

  })
}
}
