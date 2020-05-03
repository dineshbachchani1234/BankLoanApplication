package com.example.capgemini.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capgemini.entity.Loan;


//JpaRepository is being extended which is having all the required function to processed the data into and from the database 
//This is DAO layer for the Loan detail
public interface LoanDAO extends JpaRepository<Loan, Integer> {

}
