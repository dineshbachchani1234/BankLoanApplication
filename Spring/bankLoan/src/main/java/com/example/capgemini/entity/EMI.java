package com.example.capgemini.entity;

//Bean class used to print the EMI for the applied Loan
public class EMI {

	private int loan_id;
	private double emi;
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	@Override
	public String toString() {
		return "EMI [loan_id=" + loan_id + ", emi=" + emi + "]";
	}
	
}
