package com.example.capgemini.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capgemini.entity.Customer;

//JpaRepository is being extended which is having all the required function to processed the data into and from the database 
//This is DAO layer for the Customer details
public interface LoanRepository extends JpaRepository<Customer, Integer>{

	
	//For finding the User based on the name entered by the user
	Customer findByName(String name);
}
