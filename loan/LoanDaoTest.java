package loan;

import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class LoanDaoTest {
	LoanDao loanDao;
	@BeforeEach
	public void init() {
		loanDao = new LoanDaoImpl();
	}
	
	@Test
	public void LoanTest1() { //selectAllLoanTest
		List<Loan> loanList = loanDao.readLoans();
	Assertions.assertTrue(loanList!=null);
		System.out.println("Loan details are extracted...");
	Assertions.assertTrue(loanList.size()>0);
		for (Loan loan : loanList) {
			System.out.println("Loan : "+loan);
		}
	}
	
	@Test
	public void LoanTest2() { //singleSelectLoanTest
		Loan loan = loanDao.readLoan(3001);
	Assertions.assertNotNull(loan);
		System.out.println("Loan record has been extracted...");
	Assertions.assertEquals(loan.getLoan_number(),1001);
	Assertions.assertEquals(loan.getAmount(), 2000000);
	Assertions.assertEquals(loan.getCustomer_id(), 1001);
	Assertions.assertEquals(loan.getRate_of_interest(), 5.75);
	Assertions.assertEquals(loan.getTenure(), 60);
	Assertions.assertEquals(loan.getTotal_amount_to_pay(), 2400000);
	Assertions.assertEquals(loan.getAmount_left_to_pay(), 1200000);
//		System.out.println(loan.getDate_of_loan());
//		@SuppressWarnings("deprecation")
//		Date d1 = new Date(2023,01,15);
//	Assertions.assertEquals(loan.getDate_of_loan(),d1);
		System.out.println("All records are correct");
	}
	
	@Test
	public void loanTest3() { //insertLoanTest
//		loanDao.deleteloanomer(0);
		Loan loan = new Loan();
		int testLoanId = 0;
		int testLoanNumber = 0;
		int testAmount = 0;
		int testCoustomer_id = 1001;
		int testROI = 0;
		int testTenure = 0;
		int testTotal_amount_to_pay = 0;
		int testAmount_left_to_pay = 0;
		Date testDate = new Date(2000,0,0);
		
		loan.setLoan_id(testLoanId);
		loan.setLoan_number(testLoanNumber);
		loan.setAmount(testAmount);
		loan.setCustomer_id(testCoustomer_id);
		loan.setRate_of_interest(testROI);
		loan.setTenure(testTenure);
		loan.setTotal_amount_to_pay(testTotal_amount_to_pay);
		loan.setAmount_left_to_pay(testAmount_left_to_pay);
		loan.setDate_of_loan(testDate);
//		System.out.println(loan.getDate_of_loan());
		
		List<Loan> loanList = loanDao.readLoans();
		int initialSize = loanList.size();
		loanDao.createLoan(loan);
		loanList = loanDao.readLoans();
		int currentSize = loanList.size();
	Assertions.assertEquals(initialSize+1,currentSize);
		System.out.println("Loan added successfully : " + loan);
		Loan temploan = loanDao.readLoan(testLoanId);
		
	Assertions.assertEquals(temploan.getLoan_id(), loan.getLoan_id());
	Assertions.assertEquals(temploan.getLoan_number(), loan.getLoan_number());
	Assertions.assertEquals(temploan.getAmount(), loan.getAmount());
	Assertions.assertEquals(temploan.getCustomer_id(), loan.getCustomer_id());
	Assertions.assertEquals(temploan.getRate_of_interest(), loan.getRate_of_interest());
	Assertions.assertEquals(temploan.getTenure(), loan.getTenure());
	Assertions.assertEquals(temploan.getTotal_amount_to_pay(), loan.getTotal_amount_to_pay());
	Assertions.assertEquals(temploan.getAmount_left_to_pay(), loan.getAmount_left_to_pay());

//	Assertions.assertEquals(loan, loanDao.readloanomer(testId));
		System.out.println("Data is matching");
	
	}
	
	@Test
	public void loanTest4() { //updateLoanTest
		Loan loan = new Loan();
		int testLoanId = 0;
		int testLoanNumber = 1;
		int testAmount = 1;
		int testCoustomer_id = 1001;
		int testROI = 1;
		int testTenure = 1;
		int testTotal_amount_to_pay = 1;
		int testAmount_left_to_pay = 1;
		Date testDate = new Date(2000,0,0);
		
		loan.setLoan_id(testLoanId);
		loan.setLoan_number(testLoanNumber);
		loan.setAmount(testAmount);
		loan.setCustomer_id(testCoustomer_id);
		loan.setRate_of_interest(testROI);
		loan.setTenure(testTenure);
		loan.setTotal_amount_to_pay(testTotal_amount_to_pay);
		loan.setAmount_left_to_pay(testAmount_left_to_pay);
		loan.setDate_of_loan(testDate);
		
		loanDao.updateLoan(loan);
		System.out.println("Data updated..");
		Loan temploan = loanDao.readLoan(testLoanId);
		
	Assertions.assertEquals(temploan.getLoan_id(), loan.getLoan_id());
	Assertions.assertEquals(temploan.getLoan_number(), loan.getLoan_number());
	Assertions.assertEquals(temploan.getAmount(), loan.getAmount());
	Assertions.assertEquals(temploan.getCustomer_id(), loan.getCustomer_id());
	Assertions.assertEquals(temploan.getRate_of_interest(), loan.getRate_of_interest());
	Assertions.assertEquals(temploan.getTenure(), loan.getTenure());
	Assertions.assertEquals(temploan.getTotal_amount_to_pay(), loan.getTotal_amount_to_pay());
	Assertions.assertEquals(temploan.getAmount_left_to_pay(), loan.getAmount_left_to_pay());
		System.out.println("Data is matching");
	}
	
	@Test
	public void loanTest5() { //deleteLoanTest
		int testId=0;
		List<Loan> loanList = loanDao.readLoans();
		int initialSize = loanList.size();
		loanDao.deleteLoan(testId);
		loanList = loanDao.readLoans();
		int currentSize = loanList.size();
	Assertions.assertEquals(initialSize-1,currentSize);
		System.out.println("Loan has been deleted");
	}
}