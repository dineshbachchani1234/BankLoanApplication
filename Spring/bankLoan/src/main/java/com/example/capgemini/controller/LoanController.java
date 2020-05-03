package com.example.capgemini.controller;

import java.util.List;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capgemini.entity.Calculate;
import com.example.capgemini.entity.Customer;
import com.example.capgemini.entity.EMI;
import com.example.capgemini.entity.Loan;
import com.example.capgemini.entity.Money;
import com.example.capgemini.entity.Transactions;
import com.example.capgemini.service.LoanService;
import com.example.capgemini.utility.GlobalResources;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*")  

//@RestController simplifies the controller implementation
//@RestController is a specialized version of the controller. 
//It includes the @Controller and @ResponseBody annotations 

//@RequestMapping is one the most common annotation used in Spring web application.
//This annotation maps HTTP requests to handler methods of MVC and REST controllers.

//Cross origin is being used as we are connecting Angular and Spring boot both uses different port.
//Angular by f=default runs on 4200 and spring boot runs on 8080, So we uses cross origin

public class LoanController {

	/*This annotation is for dependency injection
	Will automatically inject the dependent beans*/
	@Autowired
	private LoanService service;
	
	private Logger logger=GlobalResources.getLogger(LoanController.class);
	
	
//  Add Customer method is used to create a new account for a new user with the specific details.
//  Provided the required validation in front end(angular).	
	@PostMapping("/signup")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		String methodName="addCustomer()";
		logger.info(methodName + "of controller class called");
		return service.saveCustomer(customer);
	}
	
//	This method will display the list of all users.
//  
	@GetMapping("/all")
	public List<Customer> allCustomers()
	{
		String methodName="allCustomers()";
		logger.info(methodName + "of controller class called");
		return service.getCustomers();
	}
	
	//This method is used to display the account balance based on the account number entered by the customer
	@GetMapping("/check-balance/{acc_number}")
	public double showBalance(@PathVariable int acc_number)
	{
		String methodName="showBalance()";
		logger.info(methodName + "of controller class called");
		Customer c=service.getCustomerById(acc_number);
		return c.getBalance();
	}
	
	//This method will print the Monthly EMI based on the loan id entered by the customer
	@GetMapping("/emishow/{loan_id}")
	public double showEMI(@PathVariable int loan_id)
	{
		String methodName="showEMI()";
		logger.info(methodName + "of controller class called");
		Loan loan=service.getLoanById(loan_id);
		return loan.getEmi();
	}
	
	//Method help us to add more balance in the existing bank account.
	//For this function, a new class(bean) is being created and in which the value of form is being added.
	//two values are being passed: acc_number and balance(which we have to add)
	@PostMapping("/add-balance")
	public double addBalance(@RequestBody Money money)
	{
		String methodName="addBalance()";
		logger.info(methodName + "of controller class called");	
		return service.updateCustomer(money);
	}
	//This method help us to apply for the loan.
	//The form value will be passed to the loan entity 
	//loan entity is having a foreign key (acc_number)
	//Mapping takes place between customer and loan
	@PostMapping("/loan")
	public Integer applyLoan(@RequestBody Loan loan)
	{
		String methodName="applyLoan()";
		logger.info(methodName + "of controller class called");
	return service.applyLoan(loan);
	}
	//Will allow us to pay the monthly EMI
	//By just pressing the button, the monthly EMI will be deduced based on the loan_id entered by the user
	
	@GetMapping("/payemi/{loan_id}/{acc_number}")
	public double payEmi(@PathVariable int loan_id,@PathVariable int acc_number)
	{
		String methodName="payEmi()";
		logger.info(methodName + "of controller class called");
		return service.updateLoan(loan_id,acc_number);
	}
	//This function will print the Remaining Loan Balance and main balance after paying the monthly EMI
	//Based on the acc_number fetched from the front end, loan balance and main balance is passed
	@GetMapping("/emi-balance/{acc_number}/{loan_id}")
	public double emiBalance(@PathVariable int acc_number,@PathVariable int loan_id)
	{
		String methodName="emiBalance()";
		logger.info(methodName + "of controller class called");
		return service.printBalance(acc_number,loan_id);
	}
	//This function provide the feature of foreclosing an account
	//The remaining loan balance will be deducted from account balance and the updated balance will print
	//Loan details will set to zero as we foreclose that account
	@GetMapping("/foreclose/{acc_number}/{loan_id}")
	public double foreClose(@PathVariable Integer acc_number,@PathVariable int loan_id)
	{
		String methodName="foreClose()";
		logger.info(methodName + "of controller class called");
		return service.foreCloseAccount(acc_number,loan_id);
	}
	
	//Calculate the EMI according to the loan amount and duration entered by the user
	//This uses separate bean class in which loan amount and duration are the variables 
	//Value entered by the form will be passed to that bean class variables
	@PostMapping("/calculateEMI")
	public double calculate(@RequestBody Calculate calculate)
	{
		String methodName="calculate()";
		logger.info(methodName + "of controller class called");
		return service.calulateEmi(calculate);
	}
	
	//Login authentication takes place during this function
	//User will enter the email id and password.
	//Checking of user id and password from the pool of email id and password and if result matches
	//then login succeed otherwise an error message will print on the screen
	@PostMapping("/login")
	public Integer loginVerify(@RequestBody Customer customer)
	{
		String methodName="loginVerify()";
		logger.info(methodName + "of controller class called");
		Integer acc_number=null;
		boolean idFound=false;
		for(Customer cust: service.getCustomers()) {
			if(cust.getEmail().equals(customer.getEmail()) && cust.getPassword().equals(customer.getPassword()))
			{
			acc_number=cust.getAcc_number();	
			idFound=true;
			break;
			}
		}
		return acc_number;
	}
	
	//Will help to add the transaction occur during different functions
	@PostMapping("/addTransaction")
	public Transactions Transaction(@RequestBody Transactions transaction)
	{

		String methodName="Transaction()";
		logger.info(methodName + "of controller class called");
		return service.addTransaction(transaction);
	}
		
	//Print transactions with time
	@GetMapping("/printTransactions/{acc_number}")
	public List<Transactions> printTransactions(@PathVariable int acc_number)
	{
		String methodName="printTransactions()";
		logger.info(methodName + "of controller class called");
        return service.printTransactionsById(acc_number);
	}
}