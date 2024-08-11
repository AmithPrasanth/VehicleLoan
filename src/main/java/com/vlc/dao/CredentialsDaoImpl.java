package com.vlc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CredentialsDaoImpl implements CredentialsDao {

	
Connection conn=null;
	
	public CredentialsDaoImpl() {
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
	public void createCredentials(Credentials credObj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("insert into credentials values (?,?)");
			
			pst.setString(1, credObj.getUsername());
			pst.setString(2, credObj.getPassword());
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Credentials readCredential(String username) {
		Credentials cred = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from credentials where username="+username);
			if(result.next()) {
				cred = new Credentials();
				cred.setPassword(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cred;
	}

	@Override
	public List<Credentials> readCredentials() {
		Credentials cred = null;
		ArrayList<Credentials> credList = new ArrayList<Credentials>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from credentials");
			
			while(result.next()) {
				cred = new Credentials();
				cred.setUsername(result.getString(1));
				cred.setPassword(result.getString(2));
				credList.add(cred);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return credList;
	}

	@Override
	public void updateCredential(Credentials credObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("update customer set password=? where username=?");
			
			pst.setString(2,credObj.getUsername()); //WHERE
			pst.setString(1, credObj.getPassword()); //set col1
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) updated : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCredential(String username) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from credentials where username=?");
			
			pst.setString(1,username); //WHERE
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) deleted : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
