package com.example.capgemini.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.capgemini.entity.Transactions;

//JpaRepository is being extended which is having all the required function to processed the data into and from the database 
//This is DAO layer for the Transactions details
public interface TransactionsRepo extends CrudRepository<Transactions, Integer>{

}
