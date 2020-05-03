import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-emishow',
  templateUrl: './emishow.component.html',
  styleUrls: ['./emishow.component.css']
})
export class EmishowComponent implements OnInit {
message:any;
  constructor(private router:Router,private service:BookService) { }

  ngOnInit() {
    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }

  }
public knowemi()
{
let emi=this.service.emishow(localStorage.loanid);
emi.subscribe((data)=>localStorage.emi=this.message=data);

console.log(localStorage.emi);
}
}
