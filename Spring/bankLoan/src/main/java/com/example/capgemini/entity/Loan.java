package com.example.capgemini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Bean class which is used to apply the loan for the logged in customer

@Entity
@Table(name="loan")
public class Loan {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_id;
	private double loan_amount;
	private double loan_balance;
	private double emi;
	private int duration;
	
	//Many to one implementation
	@ManyToOne
	@JoinColumn(name="acc_number")
	private Customer customer;
	public double getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}
	public double getLoan_balance() {
		return loan_balance;
	}
	public void setLoan_balance(double loan_balance) {
		this.loan_balance = loan_balance;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loan_id, double loan_amount, double loan_balance, double emi, int duration) {
		super();
		this.loan_id = loan_id;
		this.loan_amount = loan_amount;
		this.loan_balance = loan_balance;
		this.emi = emi;
		this.duration = duration;
	}
	
}
