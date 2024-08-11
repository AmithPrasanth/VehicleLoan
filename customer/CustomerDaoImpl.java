package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CustomerDaoImpl implements CustomerDao{
	
	Connection conn=null;
	
	public CustomerDaoImpl() {
		try {
			System.out.println("Registering driver...");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver registerd....");
			
			System.out.println("Trying to connect to the DB");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "password");
			System.out.println("Connected to the DB : "+conn);
			
		}
		catch(Exception e) {
			System.out.println("Problem : "+e);
		}
			
			
	}
	
	@Override
	public void createCustomer(Customer custObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,custObj.getCustomer_id());
			pst.setString(2, custObj.getName());
			pst.setInt (3,custObj.getAge());
			pst.setString(4, custObj.getGender());
			pst.setString(5, custObj.getType_of_employment());
			pst.setDouble(6,custObj.getSalary());
			pst.setDouble(7,custObj.getBalance());
			pst.setInt (8,custObj.getExisting_emis());
			pst.setLong (9,custObj.getMobile_number());
			pst.setString(10, custObj.getEmail_id());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Customer readCustomer(int cust_id) {
		Customer cust = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from customer where customer_id="+cust_id);
			if(result.next()) {
				cust = new Customer();
				cust.setCustomer_id(result.getInt(1));
				cust.setName(result.getString(2));
				cust.setAge(result.getInt(3));
				cust.setGender(result.getString(4));
				cust.setType_of_employment(result.getString(5));
				cust.setSalary(result.getDouble(6));
				cust.setBalance(result.getDouble(7));
				cust.setExisting_emis(result.getInt(8));
				cust.setMobile_number(result.getLong(9));
				cust.setEmail_id(result.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Customer> readCustomers() {
		Customer cust = null;
		ArrayList<Customer> custList = new ArrayList<Customer>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from customer");
			
			while(result.next()) {
				cust = new Customer();
				cust.setCustomer_id(result.getInt(1));
				cust.setName(result.getString(2));
				cust.setAge(result.getInt(3));
				cust.setGender(result.getString(4));
				cust.setType_of_employment(result.getString(5));
				cust.setSalary(result.getDouble(6));
				cust.setBalance(result.getDouble(7));
				cust.setExisting_emis(result.getInt(8));
				cust.setMobile_number(result.getLong(9));
				cust.setEmail_id(result.getString(10));
				custList.add(cust);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;
	}

	@Override
	public void updateCustomer(Customer custObj) {

		try {
			PreparedStatement pst = conn.prepareStatement("update customer set name=?, gender=? ,type_of_employment=?, salary=?, mobile_number=?, email_id=?   where customer_id=?");
			
			pst.setInt(7,custObj.getCustomer_id()); //WHERE
			pst.setString(1, custObj.getName()); //set col1
			pst.setString (2,custObj.getGender());		 //set col2
			pst.setString (3,custObj.getType_of_employment());
			pst.setDouble(4,custObj.getSalary());
			pst.setLong(5,custObj.getMobile_number());
			pst.setString (6,custObj.getEmail_id());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) updated : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int cust_id) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from customer where customer_id=?");
			
			pst.setInt(1,cust_id); //WHERE
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) deleted : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
