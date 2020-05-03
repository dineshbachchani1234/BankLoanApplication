package com.example.capgemini.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//This bean class is used for displaying the transactions

@Entity
@Table(name="transactions")
public class Transactions {
private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	private String statement;
	private Date time;
	
	//Many to one implementation
	@ManyToOne
	@JoinColumn(name="acc_number")
	private Customer customer;
	
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
//	public int getAcc_number() {
//		return acc_number;
//	}
//	public void setAcc_number(int acc_number) {
//		this.acc_number = acc_number;
//	}
	
	public Transactions(String statement) {
		super();
		this.statement = statement;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Transactions()
	{
		super();
	}
}
