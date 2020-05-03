package com.example.capgemini.entity;

//This bean class is just for calculating the EMI depending on the loan amount and duration entered by the user
public class Calculate {

	private double loan_amount;
	private int duration;
	public double getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
