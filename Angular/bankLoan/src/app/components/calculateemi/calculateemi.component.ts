import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-calculateemi',
  templateUrl: './calculateemi.component.html',
  styleUrls: ['./calculateemi.component.css']
})
export class CalculateemiComponent implements OnInit {
  calculateemiform:FormGroup;
message:any;
  constructor(private router:Router,private formBuilder:FormBuilder,private service:BookService) { }

  ngOnInit() {
    if(localStorage.uname==null)
    {
      this.router.navigate(["/home"])
    }

    this.calculateemiform=this.formBuilder.group({
      //balance:['',Validators.required]
      loan_amount: ['', [Validators.required, Validators.pattern('[1-9]{1}[0-9]+')]],
      duration:['',[Validators.required,Validators.pattern('[1-9]{1}[0-9]+')]]  
     
     });
  }
  public calculateemi()

  {
    let resp2=this.service.calculate(this.calculateemiform.value);
    resp2.subscribe((data)=>this.message=data);
    this.router.navigate(['/calculateemi']);

  }

  
}
