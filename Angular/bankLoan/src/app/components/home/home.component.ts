import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';
import { Customer } from 'src/app/model/customer';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loginForm: FormGroup;
  customer:Customer=new Customer();
  invalidLogin:boolean = false;
  submitted: boolean= false;
  constructor(private service:BookService, private formBuilder: FormBuilder, private router: Router) { }

  // Life Cycle Hook
  ngOnInit() {
    if(localStorage.uname!=null)
    {
      this.router.navigate(["/login"]);
    }
    if(localStorage.store==null)
    {
      this.router.navigate(["/signup"]);   
    }
    // form for login
    this.loginForm = this.formBuilder.group({
      email:['',Validators.required],
      password: ['', Validators.required]
    });
  }




  verifyLogin()
  {
    // function for verifying the login credentials
    this.customer=this.loginForm.value;
    console.log(this.customer);
    this.submitted = true;
     if(this.loginForm.invalid){
       return;
   }
   
    this.service.login(this.customer).subscribe(data=>{
      localStorage.store=data;
      // localStorage.loginName=this.loginForm.controls.name.value;
      

      // condition to logIn or deny the permission
      if(data>0)
      {
        // store email di
        localStorage.uname=this.loginForm.controls.email.value;
        this.router.navigate(['login']);
      }
     if(data==0)
      {
        alert(`Invalid Username or Password \n Try Again`);
      }
      console.log(data);
    })
    }
} 