package customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class CustomerDaoTest {

    private CustomerDao customerDao;

    @BeforeEach
    public void init() {
        customerDao = new CustomerDaoImpl(); // Initialize the DAO implementation
    }

    @Test
    public void testReadAllCustomers() { // Test to read all customers
        List<Customer> customerList = customerDao.readCustomers();
        Assertions.assertNotNull(customerList);
        System.out.println("Customer details are extracted...");
        Assertions.assertTrue(customerList.size() > 0);
        for (Customer customer : customerList) {
            System.out.println("Customer: " + customer);
        }
    }

    @Test
    public void testReadCustomer() { // Test to read a single customer
        Customer customer = customerDao.readCustomer(1001); 
        Assertions.assertNotNull(customer);
        System.out.println("Customer record has been extracted...");
        Assertions.assertEquals(customer.getCustomer_id(), 1001);
        Assertions.assertEquals(customer.getName(), "John Doe");
        Assertions.assertEquals(customer.getAge(), 30);
        Assertions.assertEquals(customer.getGender(), "Male");
        Assertions.assertEquals(customer.getType_of_employment(), "IT");
        Assertions.assertEquals(customer.getSalary(), 50000.0);
        Assertions.assertEquals(customer.getBalance(), 100000.0);
        Assertions.assertEquals(customer.getExisting_emis(), 5000);
        Assertions.assertEquals(customer.getMobile_number(), 1234567890L);
        Assertions.assertEquals(customer.getEmail_id(), "john.doe@abc.com");
        System.out.println("All records are correct");
    }

    @Test
    public void testCreateCustomer() { // Test to insert a new customer
        Customer customer = new Customer();
        int testId = 0; // Use a unique ID for testing
        String testName = "testname";
        int testAge = 0;
        String testGender = "Male";
        String testEmployment = "testtype";
        double testSalary = 0;
        double testBalance = 0;
        int testExistingEmis = 0;
        long testMobileNumber = 0L;
        String testEmail = "testmail";

        customer.setCustomer_id(testId);
        customer.setName(testName);
        customer.setAge(testAge);
        customer.setGender(testGender);
        customer.setType_of_employment(testEmployment);
        customer.setSalary(testSalary);
        customer.setBalance(testBalance);
        customer.setExisting_emis(testExistingEmis);
        customer.setMobile_number(testMobileNumber);
        customer.setEmail_id(testEmail);

        List<Customer> customerList = customerDao.readCustomers();
        int initialSize = customerList.size();
        customerDao.createCustomer(customer);
        customerList = customerDao.readCustomers();
        int currentSize = customerList.size();
        Assertions.assertEquals(initialSize + 1, currentSize);
        System.out.println("Customer added successfully: " + customer);

        Customer retrievedCustomer = customerDao.readCustomer(testId);
        Assertions.assertEquals(retrievedCustomer.getCustomer_id(), customer.getCustomer_id());
        Assertions.assertEquals(retrievedCustomer.getName(), customer.getName());
        Assertions.assertEquals(retrievedCustomer.getAge(), customer.getAge());
        Assertions.assertEquals(retrievedCustomer.getGender(), customer.getGender());
        Assertions.assertEquals(retrievedCustomer.getType_of_employment(), customer.getType_of_employment());
        Assertions.assertEquals(retrievedCustomer.getSalary(), customer.getSalary());
        Assertions.assertEquals(retrievedCustomer.getBalance(), customer.getBalance());
        Assertions.assertEquals(retrievedCustomer.getExisting_emis(), customer.getExisting_emis());
        Assertions.assertEquals(retrievedCustomer.getMobile_number(), customer.getMobile_number());
        Assertions.assertEquals(retrievedCustomer.getEmail_id(), customer.getEmail_id());
        System.out.println("Data is matching");
    }

    @Test
    public void testUpdateCustomer() { // Test to update an existing customer
        Customer customer = new Customer();
        int testId = 0; // Use a unique ID for testing
        String testName = "testname1";
        int testAge = 1;
        String testGender = "Male";
        String testEmployment = "testtype1";
        double testSalary = 1;
        double testBalance = 1;
        int testExistingEmis = 1;
        long testMobileNumber = 1L;
        String testEmail = "testmail1";

        customer.setCustomer_id(testId);
        customer.setName(testName);
        customer.setAge(testAge);
        customer.setGender(testGender);
        customer.setType_of_employment(testEmployment);
        customer.setSalary(testSalary);
        customer.setBalance(testBalance);
        customer.setExisting_emis(testExistingEmis);
        customer.setMobile_number(testMobileNumber);
        customer.setEmail_id(testEmail);

        customerDao.updateCustomer(customer);
        System.out.println("Customer data updated...");
        Customer updatedCustomer = customerDao.readCustomer(testId);

        Assertions.assertEquals(updatedCustomer.getCustomer_id(), customer.getCustomer_id());
        Assertions.assertEquals(updatedCustomer.getName(), customer.getName());
        Assertions.assertEquals(updatedCustomer.getMobile_number(), customer.getMobile_number());
        Assertions.assertEquals(updatedCustomer.getEmail_id(), customer.getEmail_id());
        System.out.println("Data is matching");
    }

    @Test
    public void testDeleteCustomer() { // Test to delete a customer
        int testId = 0; // Use an ID that exists in your test database
        List<Customer> customerList = customerDao.readCustomers();
        int initialSize = customerList.size();
        customerDao.deleteCustomer(testId);
        customerList = customerDao.readCustomers();
        int currentSize = customerList.size();
        Assertions.assertEquals(initialSize - 1, currentSize);
        System.out.println("Customer has been deleted");
    }
}
