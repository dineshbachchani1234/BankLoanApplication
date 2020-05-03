import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/service/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-foreclose2',
  templateUrl: './foreclose2.component.html',
  styleUrls: ['./foreclose2.component.css']
})
export class Foreclose2Component implements OnInit {
acc_balance:any;
  constructor(private service:BookService,private router:Router) { }

  ngOnInit() {
    this.acc_balance=localStorage.foreclosebalance;
    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }
  }
  // delete()
  // {
  //   let resp5=this.service.delete(localStorage.store);
  //   resp5.subscribe((data)=>localStorage.account=data);
    
  //   this.router.navigate(["/delete"]);
  // }
}
