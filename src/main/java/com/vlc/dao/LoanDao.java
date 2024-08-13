package com.vlc.dao;

import java.util.List;

public interface LoanDao {
	void             createLoan(Loan loanObj);
	Loan 	         readLoan(int loan_id);
	List<Loan>       readLoans();
	List<Loan>       readRejectedLoans();
	List<Loan>       readPendingLoans();
	void             updateLoan(Loan loanObj);
	void 			 deleteLoan(int loan_id);
}
