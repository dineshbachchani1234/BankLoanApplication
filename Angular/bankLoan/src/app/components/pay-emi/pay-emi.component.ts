import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';
import { Transactions } from 'src/app/model/transactions';

@Component({
  selector: 'app-pay-emi',
  templateUrl: './pay-emi.component.html',
  styleUrls: ['./pay-emi.component.css']
})
export class PayEmiComponent implements OnInit {
  transaction :Transactions=new Transactions;
  message:any;
  submitted:boolean=false;
  constructor(private service:BookService,private router:Router,private formBuilder:FormBuilder) { }
  ngOnInit(): void {
    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }
   }
  
payEmi()
{

  // function to pay the EMI
  // this.transaction.acc_number=localStorage.store;
  //   this.transaction.time=new Date();
  //   this.transaction.statement="EMI paid Successfully. Your account is being debited by amount " +localStorage.emi;  
  let pay=this.service.pay(localStorage.loanid,localStorage.store);
  pay.subscribe((data)=>localStorage.loan_balance=data);
  // route to after EMI page
  this.service.addTransaction(this.transaction).subscribe((data)=>
  {
    //console.log("after adding");
    console.log(data);
  },
  err=>
  {
    console.log(err);
  })

  this.router.navigate(['/afteremi']);
}
}