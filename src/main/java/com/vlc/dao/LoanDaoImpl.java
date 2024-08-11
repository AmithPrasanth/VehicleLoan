package com.vlc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LoanDaoImpl implements LoanDao {

	Connection conn=null;
	
	public LoanDaoImpl() {
		try {
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver registerd....");
			
			System.out.println("Trying to connect to the DB");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "amith2002");
			System.out.println("Connected to the DB : "+conn);
			
		}
		catch(Exception e) {
			System.out.println("Problem : "+e);
		}
	}
	
	@Override
	public void createLoan(Loan loanObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into vehicle values (?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,loanObj.getLoan_id());
			pst.setInt(2,loanObj.getLoan_number());
			pst.setInt(3,loanObj.getAmount());
			pst.setInt(4,loanObj.getCustomer_id());
			pst.setFloat(5,loanObj.getRate_of_interest());
			pst.setInt(6,loanObj.getTenure());
			pst.setInt(7,loanObj.getTotal_amount_to_pay());
			pst.setInt(8,loanObj.getAmount_left_to_pay());
			pst.setDate(9,(Date) loanObj.getDate_of_loan());
	        
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Loan readLoan(int loan_id) {
		Loan loan = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Loan where loan_id="+loan_id);
			if(result.next()) {
				loan = new Loan();
				loan.setLoan_id(result.getInt(1));
				loan.setLoan_number(result.getInt(2));
				loan.setAmount(result.getInt(3));
				loan.setCustomer_id(result.getInt(4));
				loan.setRate_of_interest(result.getFloat(5));
				loan.setTenure(result.getInt(6));
				loan.setTotal_amount_to_pay(result.getInt(7));
				loan.setAmount_left_to_pay(result.getInt(8));
				loan.setDate_of_loan(result.getDate(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loan;
	}

	@Override
	public List<Loan> readLoans() {
		Loan loan = null;
		ArrayList<Loan> loanList = new ArrayList<Loan>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from loan");
			
			while(result.next()) {
				loan = new Loan();
				loan.setLoan_id(result.getInt(1));
				loan.setLoan_number(result.getInt(2));
				loan.setAmount(result.getInt(3));
				loan.setCustomer_id(result.getInt(4));
				loan.setRate_of_interest(result.getFloat(5));
				loan.setTenure(result.getInt(6));
				loan.setTotal_amount_to_pay(result.getInt(7));
				loan.setAmount_left_to_pay(result.getInt(8));
				loan.setDate_of_loan(result.getDate(9));
				loanList.add(loan);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}

	@Override
	public void updateLoan(Loan loanObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("update loan set loan_number=?,amount=?,customer_id=?,rate_of_interest=?,tenure=?,total_amount_to_pay=?,amount_left_to_pay=?,date_of_loan=? where vehicle_id=?");
			pst.setInt(9,loanObj.getLoan_id());
			pst.setInt(1,loanObj.getLoan_number());
			pst.setInt(2,loanObj.getAmount());
			pst.setInt(3,loanObj.getCustomer_id());
			pst.setFloat(4,loanObj.getRate_of_interest());
			pst.setInt(5,loanObj.getTenure());
			pst.setInt(6,loanObj.getTotal_amount_to_pay());
			pst.setInt(7,loanObj.getAmount_left_to_pay());
			pst.setDate(8,(Date) loanObj.getDate_of_loan());
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) updated : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLoan(int loan_id) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from loan where loan_id=?");
			
			pst.setInt(1,loan_id); //WHERE
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) deleted : ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
