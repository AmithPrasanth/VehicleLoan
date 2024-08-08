package customer;

import java.util.List;

import org.json.simple.JSONObject;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDaoImpl();

		int i=0;
		List<Customer> custList = dao.readCustomers();
		JSONObject jsonArray[]=new JSONObject[20];
		for(Customer cust : custList) {
			
			   JSONObject jsonObj1=new JSONObject();
			   int cust_id = cust.getCustomer_id();
			   String name = cust.getName();
			   int age = cust.getAge();
			   String gender = cust.getGender();
			   String Type_Of_Employment = cust.getType_of_employment();
			   double salary = cust.getSalary();
			   double balance = cust.getBalance();
			   int existing_emis = cust.getExisting_emis();
			   long mobile_number = cust.getMobile_number();;
			   String email_id= cust.getEmail_id(); ;
			    
			   jsonObj1.put("NAME",name);
		       jsonObj1.put("ID",cust_id);
		       jsonObj1.put("AGE",age);
		       jsonObj1.put("GENDER",gender);
		       jsonObj1.put("EMPLOYMENT TYPE",Type_Of_Employment);
		       jsonObj1.put("SALARY",salary);
		       jsonObj1.put("BALANCE",balance);
		       jsonObj1.put("EXSISTING EMIS",existing_emis);
		       jsonObj1.put("MOBILE NUMBER",mobile_number);
		       jsonObj1.put("EMAIL ID",email_id);
		       jsonArray[i]=jsonObj1;
		       ++i;
		}
		for(JSONObject j : jsonArray)
		     System.out.println(j);



		}
	}
