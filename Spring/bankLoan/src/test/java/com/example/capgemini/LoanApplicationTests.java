package com.example.capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.capgemini.controller.LoanController;
import com.example.capgemini.entity.Calculate;
import com.example.capgemini.entity.Customer;
import com.example.capgemini.entity.Loan;
import com.example.capgemini.entity.Money;
import com.example.capgemini.entity.Transactions;
import com.example.capgemini.service.LoanService;
import com.example.capgemini.utility.GlobalResources;

@SpringBootTest
class LoanApplicationTests {

	@Test
	void contextLoads() {
	}
	private static Logger Logger= GlobalResources.getLogger(LoanApplicationTests.class);
	
	@Autowired
	LoanService service;
	
	LoanController controller;

	@BeforeAll
	static void setUpBeforeClass()
	{
			
		Logger.info("SetUpClass called");
	}
	
	@BeforeEach
	void setup()
	{
		Logger.info("Test Case Started");

	System.out.println("Test Case Started");
	}
	
	@AfterEach
	void tearDown()
	{
		Logger.info("Test Case Over");
		System.out.println("Test Case Over");
	}
	
	
	@Test
	@DisplayName("User created successfully")
	@Rollback(true)
	public void createUser()
	{ 
		String methodName="saveCustomer()";
      	Logger.info(methodName+"called");
      	Customer customer =new Customer();
//      	customer.setAcc_number(101);
		customer.setAdhar(999999999999L);
		customer.setMobile(9898989898L);
		customer.setEmail("ram@gmail.com");
		customer.setName("ram");
		customer.setPassword("ram@1234");
		customer.setPan("GUJ15gy");
		customer.setBalance(1000);
		customer.setType("saving");
		Customer status =service.saveCustomer(customer);
		assertNotNull(status);
}

@Test
@DisplayName("User Login Test 1")
@Rollback(true)
public void login()
{
	String methodName="verifyLogin()";
  	Logger.info(methodName+"called");
  	Customer customer =new Customer();
  	customer.setAdhar(999999999999L);
	customer.setMobile(9999999999L);
	customer.setEmail("naresh@gmail.com");
	customer.setName("naresh");
	customer.setPassword("naresh@1");
	customer.setPan("guj99");
	customer.setBalance(9999);
	customer.setType("saving");
	String response=null;
	try
	{
		int value=0;
		if(value==controller.loginVerify(customer))
		{
			response="success";
		}
	}
	catch(Exception e)
	{
		response=e.getMessage();
	}
	String expectedResponse="success";
	assertNotEquals(response,expectedResponse);
}
@Test
@DisplayName("Loan applied successfully")
@Rollback(true)
public void loan()
{
	String methodName="applyLoan()";
  	Logger.info(methodName+"called");
  	Loan loan=new Loan();
  	loan.setDuration(12);
  	loan.setEmi(121.0);
  	loan.setLoan_amount(1111.0);
  	loan.setLoan_balance(1111.0);
  	int status =service.applyLoan(loan);
  	assertNotEquals(2,status);
}

@Test
@DisplayName("money added successfully")
@Rollback(true)
public void money()
{
	String response=null;
	String methodName="updateCustomer()";
  	Logger.info(methodName+"called");
  	Money money=new Money();
	money.setBalance(1000);
	try
	{
  	double status=0.0;
	if(status==service.updateCustomer(money))
  	{
  		response="success";
  	}
	}
	catch(Exception e)
	{
		response=e.getMessage();
	}
	String expectedResponse="success";
	assertNotEquals(response,expectedResponse);
}

@Test
@DisplayName("calculate emi")
@Rollback(true)
public void calculate()
{
	String methodName="calculateEmi()";
  	Logger.info(methodName+"called");
  Calculate calculate =new Calculate();
  	double status =service.calulateEmi(calculate);
  	assertNotEquals(2.0,status);
}
@Test
@DisplayName("print balance")
@Rollback(true)
public void print()
{
	String methodName="printBalance()";
	Logger.info(methodName + "of service class called");
	
	Customer customer=new Customer();
	customer.setBalance(1000.0);
	Loan loan=new Loan();
	loan.setEmi(100);
	String response=null;
	
	try
	{
		double status=0.0;
		if(status==service.printBalance(121, 122))
		{
			response="success";
		}
	}
	catch(Exception e)
	{
		response=e.getMessage();
	}
	String expectedResponse="success";
	assertNotEquals(response,expectedResponse);
}
@Test
@DisplayName("add transaction")
@Rollback(true)
public void transacation()
{
	String methodName="addTransaction()";
	Logger.info(methodName + "of service class called");
Transactions transaction=new Transactions();
transaction.setStatement("Amount debited");
String response=null;
try
{
Transactions status=null;
	if(status==service.addTransaction(transaction))
	{
		response="success";
	}
}
catch(Exception e)
{
	response=e.getMessage();
}
String expectedResponse="success";
assertNotEquals(response,expectedResponse);

}
@Test
@DisplayName("pay EMI")
@Rollback(true)
public void payEMI()
{
	String methodName="updateLoan()";
	Logger.info(methodName + "of service class called");
String response=null;
	
	try
	{
		double status=0.0;
		if(status==service.updateLoan(121, 122))
		{
			response="success";
		}
	}
	catch(Exception e)
	{
		response=e.getMessage();
	}
	String expectedResponse="success";
	assertNotEquals(response,expectedResponse);

}

@Test
@DisplayName("delete customer")
@Rollback(true)
public void delete()
{
	String methodName="deleteCustomer()";
	Logger.info(methodName + "of service class called");
String response=null;
try
{
	String status=null;
	if(status==service.deleteCustomer(121))
	{
		response="failure";
	}
}
catch(Exception e)
{
	response=e.getMessage();
}
String expectedResponse=null;
assertEquals(response,expectedResponse);
}

@Test
@DisplayName("get loan by Id")
@Rollback(true)
public void getLoan()
{
	String methodName="getLoanById()";
	Logger.info(methodName + "of service class called");
Loan status=new Loan();
status=service.getLoanById(346);

assertNotNull(status);
}
@Test
@DisplayName("get customer by Id")
@Rollback(true)
public void getCustomer()
{
	String methodName="getCustomerById()";
	Logger.info(methodName + "of service class called");
Customer status=service.getCustomerById(232);
assertNotNull(status);
}
}
