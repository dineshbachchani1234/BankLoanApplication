import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BookService } from 'src/app/service/book.service';
import { Location } from '@angular/common';
import { OwnerForCreation } from 'src/app/model/OwnerForCreation';
import { Router } from '@angular/router';
import { Transactions } from 'src/app/model/transactions';

@Component({
  selector: 'app-show-transactions',
  templateUrl: './show-transactions.component.html',
  styleUrls: ['./show-transactions.component.css']
})
export class ShowTransactionsComponent implements OnInit {
  message:any;
  transaction:Transactions[];
  constructor(private service:BookService,private router:Router) { }

  ngOnInit() {

    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }
    this.service.printTransactions(localStorage.store).subscribe((data)=>
    {
      console.log(data);
      this.transaction=data;
      console.log(this.transaction);
      // this.message=data;
    });
    
}
}
