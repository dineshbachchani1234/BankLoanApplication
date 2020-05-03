package com.example.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capgemini.DAO.LoanDAO;
import com.example.capgemini.DAO.LoanRepository;
import com.example.capgemini.DAO.TransactionsRepo;
import com.example.capgemini.entity.Calculate;
import com.example.capgemini.entity.Customer;
import com.example.capgemini.entity.EMI;
import com.example.capgemini.entity.Loan;
import com.example.capgemini.entity.Money;
import com.example.capgemini.entity.Transactions;
import com.example.capgemini.utility.GlobalResources;


//Annotation @Service will help the compiler to understand that this is the service class responsible for the business logic
@Service
public class LoanService {
	
	
	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private LoanDAO repo;
	
	@Autowired
	private TransactionsRepo transrepo;
	
	private Logger logger=GlobalResources.getLogger(LoanService.class);
	
	
	//This is used to create a new user account
	//save(customer) will call the repository function and account details will be saved to database
	public Customer saveCustomer(Customer customer)
	{
		String methodName="saveCustomer()";
		logger.info(methodName + "of service class called");
		return repository.save(customer);
	}
	
	
	//This function help us to fetch the details of all the existing users
	//findAll will fetch the customer data
	public List<Customer> getCustomers()
	{
		String methodName="getCustomers()";
		logger.info(methodName + "of service class called");
		return repository.findAll();
	}
	
	//To get the user details based on the account number entered by the user
	public Customer getCustomerById(int id)
	{
		String methodName="getCustomerById()";
		logger.info(methodName + "of service class called");
		return repository.findById(id).orElse(null);
	}
	
	//This function will fetch the loanDetails based on the loan_id entered by the user
	//Same as get customer just instead of customer details, loan details will be fetched
	public Loan getLoanById(int id)
	{
		String methodName="getLoanById()";
		logger.info(methodName + "of service class called");
		return repo.findById(id).orElse(null);
	}
	
	
	//To fetch the customer details based on the customer name entered by the user
	//findByName function is created in the LoanRepository(For customer) repository class
	public Customer getCustomerByName(String name)
	{
		return repository.findByName(name);
	}
	
	
	//to delete the customer details based on the account number entered by the user
	//This function will print the string message based on the status of the operation
	public String deleteCustomer(int id)
	{
		return "Customer removed" +id;
	}
	
	
	//This function will do the business logic on the process of loan apply
	//Based on the user input of loan amount and duration, EMI is being calculated and loan_id is being automatically generated
	//generated loan_id is being passed to the front end and will be used further to process other functions
	public Integer applyLoan(Loan loan)
	{
		String methodName="applyLoan()";
		logger.info(methodName + "of service class called");
		loan.setLoan_balance(loan.getLoan_amount());
		double rate=10;
		Integer loan_id=null;
		double emi=Math.round((loan.getLoan_amount()*Math.pow((1+rate/100) ,(double)loan.getDuration()/12))/loan.getDuration());
		loan.setEmi(emi);
		repo.save(loan);
		loan_id=loan.getLoan_id();
		return loan_id;
	}
	
	
	//This function is used to pay the monthly EMI of the loan for that user.
	//The EMI amount will be deducted from the user account balance
	// User account balance and loan balance both will be updated 
	//remaining loan balance will be passed to the front end to display
	public double updateLoan(int loan_id,int acc_number)
	{
		String methodName="updateLoan()";
		logger.info(methodName + "of service class called");
		Loan loan=repo.findById(loan_id).orElse(null);
		Customer customer=repository.findById(acc_number).orElse(null);
		customer.setBalance(customer.getBalance()-loan.getEmi());
		customer.addTransaction(new Transactions("EMI Paid successfully. Your new updated account balance is "+customer.getBalance()+" on time " ));
		repository.save(customer);
		loan.setLoan_balance(loan.getLoan_balance()-loan.getEmi());
		loan.setDuration(loan.getDuration()-1);
		repo.save(loan);
		return loan.getLoan_balance();
	}
	
	//Help to add the transactions. It will call TransactionsRepo which is extending JPARepository
	public Transactions addTransaction(Transactions transaction)
	{
		String methodName="addTransaction()";
		logger.info(methodName + "of service class called");
		return transrepo.save(transaction);
	}
	
	
	//Return type with List, it will print all the transactions based on the account number
	public List<Transactions> printTransactionsById(int acc_number)
	{
		String methodName="printTransactionsById()";
		logger.info(methodName + "of service class called");
		Customer customer=repository.findById(acc_number).orElse(null);
		return customer.getTransaction();

	}
	
	
	//After paying the monthly EMI, the account balance will also be updated
	//To print the updated account balance, this function is used
	//Based on the account number fetched from the front end, account balance will be taken from the database
	//and will print on the front end
	public double printBalance(int acc_number,int loan_id)
	{
	
		String methodName="printBalance()";
		logger.info(methodName + "of service class called");
		Customer customer=repository.findById(acc_number).orElse(null);
		Loan loan=repo.findById(loan_id).orElse(null);
		customer.setBalance(customer.getBalance()-loan.getEmi());
		return customer.getBalance();
	}
	
	
	//Function will be used to foreClose the account.
	//The loan details will set to null and the remaining loan balance will be deducted from the main balance
	public double foreCloseAccount(int acc_number,int loan_id)
	{
	
		String methodName="foreCloseAccount()";
		logger.info(methodName + "of service class called");
		Customer customer=repository.findById(acc_number).orElse(null);
		Loan loan=repo.findById(loan_id).orElse(null);		
		customer.setBalance(customer.getBalance()-loan.getLoan_balance());
		loan.setLoan_balance(0);
		loan.setDuration(0);
		loan.setLoan_amount(0);
		loan.setEmi(0);
		customer.addTransaction(new Transactions("Your Loan has been cleared successfully. Your updated account balance is: " +customer.getBalance()));
		repo.save(loan);
		repository.save(customer);
		return customer.getBalance();
	}
	
	
	//This function will update the user balance after adding more money to the remaining account balance
	//A new bean class named money is being created and the form value will be stored on that bean class
	//Bean class is having the account balance and balance variable. account number will be fetched from the front end
	//Based on the account number, the respective customer will be fetched from the database and account balance
	// of that customer is being updated and the final balance will be passed to the front end
	public double updateCustomer(Money money)
	{
		String methodName="updateCustomer()";
		logger.info(methodName + "of service class called");
		Customer customer =repository.findById(money.getAcc_number()).orElse(null);
		 customer.setBalance(money.getBalance()+customer.getBalance());
		customer.addTransaction(new Transactions("Money has been added successfully. Your updated balance is "+customer.getBalance()));
		repository.save(customer);
		return customer.getBalance();
	}

	
	//This is purely a business logic function that will help to print the calculated EMI based on the loan balance
	//and the duration entered by the user on the form.
	//A new bean class is being created and the form value will be stored on that bean
	//Note:loan id is also one of the variable apart from loan balance and duration get from the form 
	public double calulateEmi(Calculate calculate) {
		String methodName="calculateEmi()";
		logger.info(methodName + "of service class called");
		double rate=10;
		double emi=Math.round((calculate.getLoan_amount()*Math.pow((1+rate/100) ,(double)calculate.getDuration()/12))/calculate.getDuration());
		return emi;	
	}
}