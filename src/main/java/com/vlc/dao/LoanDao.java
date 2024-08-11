package com.vlc.dao;

import java.util.List;

public interface LoanDao {
	void             createLoan(Loan loanObj);
	Loan 	         readLoan(int loan_id);
	List<Loan>       readLoans();
	void             updateLoan(Loan loanObj);
	void 			 deleteLoan(int loan_id);
}
