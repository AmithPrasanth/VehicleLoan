package customer;

import java.util.List;

public interface CustomerDao { //DepartmentRepository
	//CRUD
	void             createCustomer(Customer custObj);
	Customer 		 readCustomer(int cust_id);
	List<Customer> readCustomers();
	void             updateCustomer(Customer custObj);
	void 			 deleteCustomer(int cust_id);
}