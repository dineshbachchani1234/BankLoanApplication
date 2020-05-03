import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Transactions } from 'src/app/model/transactions';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
paymentform:FormGroup;
transaction :Transactions=new Transactions;
submitted:boolean=false;
  constructor(private formBuilder:FormBuilder,private router:Router,private service:BookService) { }

  ngOnInit() {

    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }

    // form for payment page
    this.paymentform = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.pattern("[A-Z][a-z]{2,14}")]],
      email: ['', [Validators.required, Validators.email]],
      cardname: ['',Validators.required, ],
      cardnumber: ['',[Validators.required,Validators.minLength(16),Validators.pattern("[0-9]{16}")] ],
      expmonth: ['',[Validators.required,Validators.minLength(2),Validators.pattern("[0-1]{1}[0-9]{1}")] ],
      expyear: ['',[Validators.required,Validators.minLength(4),Validators.pattern("[2]{1}[0]{1}[2]{1}[0-7]{1}")] ],
      cvv: ['',[Validators.required,Validators.minLength(3),Validators.pattern("[0-9]{3}")] ],
    });
  }
  public payment()
  {
    this.submitted = true;
    if (this.paymentform.invalid) {
      return;
    }

    let resp1=this.service.addBalance(localStorage.store,localStorage.balance);
     resp1.subscribe((data)=>localStorage.tempBalance=data);
    localStorage.newBalance=localStorage.tempBalance;
    // this.transaction.acc_number=localStorage.store;
    // this.transaction.time=new Date();
    // this.transaction.statement="Your account is credited with balance " +localStorage.balance;
    // console.log(this.transaction);
    this.service.addTransaction(this.transaction).subscribe((data)=>
    {
      console.log(data);
    })
    // alert message for successfully payment message
    alert("Payment Successful");
    this.router.navigate(['/login']);
  }
}
