import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';
import { HttpClient } from '@angular/common/http';
import { Subject, Observable } from 'rxjs';
import { Transactions } from '../model/transactions';
import { Profile } from '../model/profile';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class BookService {

// time pass
getPofiles(): Profile[] {
  let profiles = [
      new Profile( 'Developer'),
      new Profile( 'Manager'),
      new Profile('Director')
  ]
  return profiles;
}
createUser(user: User) {
  //Log user data in console
 // console.log("Profile Id: " + user.profile.prId);
  console.log("Profile Name: " + user.profile.prName);
    }
// time pass

  private isMobile = new Subject();
  public screenWidth: string;
static bookstatic:Customer[];
baseUrl:string="/assets/data/books.json";
  constructor(private service:BookService,private http:HttpClient) {


    this.http.get<Customer[]>(this.baseUrl).subscribe(data=>
    {
      BookService.bookstatic=data;
    },err=>
  {
    console.log(err.stack);
  })
   }

  //  function to call the API to call the login function in the controller class in spring boot
   public login(customer)
   {
    return this.http.post("http://localhost:8080/login",customer,{responseType:'text' as 'json'});
   }
  //  function to call the API to call the add Balance function in the controller class in spring boot
// addBook() is used to add up the customer or signup the customer
   public addBook(customer)
   {
     return this.http.post("http://localhost:8080/signup",customer,{responseType:'text' as 'json'});
   }
  //     function to call the API to call the addBalance function in the controller class in spring boot
// it will take the arguments acc_number and balance
   public addBalance(acc_number:number,balance:number)
   {
       return this.http.post("http://localhost:8080/add-balance",{"acc_number":acc_number,"balance":balance},{responseType: 'text' as 'json'});
   }
  //    function to call the API to call the calculate function in the controller class in spring boot
// will take the calculate bean class
   public calculate(Calculate)
   {
     return this.http.post("http://localhost:8080/calculateEMI",Calculate,{responseType:'text' as 'json'});
   }
//   function to call the API to call the check balance function in the controller class in spring boot
// pass the acc_number as arguments
   public check(acc_number:number)
   {
     return this.http.get("http://localhost:8080/check-balance/"+acc_number);
   }
    //  function to call the API to call the emiShow function in the controller class in spring boot
// pass the loan_id as the arguments and will help to print the EMI
   public emishow(loan_id:number)
   {
     return this.http.get("http://localhost:8080/emishow/"+loan_id);
   }

    //  function to call the API to call the loan function in the controller class in spring boot
// will used loan bean class and used to apply for the loan
   public Loan(loan)
     {
      return this.http.post("http://localhost:8080/loan",loan,{responseType: 'text' as 'json'});
     
   }
    //  function to call the API to call the pay function in the controller class in spring boot
// used to pay the EMI and take laon_id as argument
   public pay(loan_id:number,acc_number:number)
   {
     return this.http.get("http://localhost:8080/payemi/"+loan_id +"/"+acc_number);
   }
    //  function to call the API to call the emibalance function in the controller class in spring boot
// will taje acc_balance as argument and will print the account balance 
public emibalance(acc_number:number,loan_id:number)
{
  return this.http.get("http://localhost:8080/emi-balance/"+acc_number + "/" +loan_id);
}
  //  function to call the API to call the foreclose function in the controller class in spring boot
// help to foreclose the account by taking acc_number as argument
public foreclose(acc_number:number,loan_id:number)
{
  return this.http.get("http://localhost:8080/foreclose/"+acc_number +"/" +loan_id);
}
  //  function to call the API to call the login function in the controller class in spring boot
// its been on construction 
// get back to it soon
public delete(acc_number)
{
  return this.http.get("http://localhost:8080/delete/"+acc_number);
}
public addTransaction(transaction:Transactions)
{
  return this.http.post("http://localhost:8080/addTransaction",transaction);
}
public printTransactions(acc_number:number)
{
  return this.http.get<Transactions[]>("http://localhost:8080/printTransactions/"+acc_number);
}
} 