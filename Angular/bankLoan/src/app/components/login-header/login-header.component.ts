import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-header',
  templateUrl: './login-header.component.html',
  styleUrls: ['./login-header.component.css']
})
export class LoginHeaderComponent implements OnInit {
message:any;
  constructor(private router:Router) { }

  ngOnInit() {
this.message=localStorage.name;
console.log(this.message);
  }
public signout()
{
  if(localStorage.uname!=null)
  {
    localStorage.removeItem("uname");
    // localStorage.store=null;
    this.router.navigate(["/home"]);
  }
}
}
