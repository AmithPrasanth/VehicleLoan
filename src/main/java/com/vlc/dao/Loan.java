package com.vlc.dao;

import java.util.Date;

public class Loan {
	 int loan_id;
	    int loan_number;
	    int amount ;
	    int customer_id ;
	    float rate_of_interest ;
	    int tenure;
	    int total_amount_to_pay ;
	    int amount_left_to_pay ;
	    String date_of_loan;
	    String status_of_loan;
	    
		public int getLoan_id() {
			return loan_id;
		}
		public void setLoan_id(int loan_id) {
			this.loan_id = loan_id;
		}
		public int getLoan_number() {
			return loan_number;
		}
		public void setLoan_number(int loan_number) {
			this.loan_number = loan_number;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
		public float getRate_of_interest() {
			return rate_of_interest;
		}
		public void setRate_of_interest(float rate_of_interest) {
			this.rate_of_interest = rate_of_interest;
		}
		public int getTotal_amount_to_pay() {
			return total_amount_to_pay;
		}
		public void setTotal_amount_to_pay(int total_amount_to_pay) {
			this.total_amount_to_pay = total_amount_to_pay;
		}
		public int getAmount_left_to_pay() {
			return amount_left_to_pay;
		}
		public void setAmount_left_to_pay(int amount_left_to_pay) {
			this.amount_left_to_pay = amount_left_to_pay;
		}
		public String getDate_of_loan() {
			return date_of_loan;
		}
		public void setDate_of_loan(String date_of_loan) {
			this.date_of_loan = date_of_loan;
		}
		public int getTenure() {
			return tenure;
		}
		public void setTenure(int tenure) {
			this.tenure = tenure;
		}
		public String getStatus_of_loan() {
			return status_of_loan;
		}
		public void setStatus_of_loan(String status_of_loan) {
			this.status_of_loan = status_of_loan;
		}
	    
	    
	    

}
