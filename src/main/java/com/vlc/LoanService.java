package com.vlc;
import com.vlc.dao.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/LoanService") // rest/UserService/greet
public class LoanService { 
 public LoanService(){
  System.out.println("LoanService() ctor");
 }
 
   @GET 
   @Path("/test") 
   @Produces(MediaType.TEXT_HTML) 
   public String welcome(){ 
      return "<h1>Welcome to Loan Service</h1>";
   }  
   
   @GET 
   @Path("/customers") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Customer> allCusts(){ 
       CustomerDao dao = new CustomerDaoImpl();
    List<Customer> custList = new ArrayList<Customer>();
    custList = dao.readCustomers();
    return custList;
   }
   
   @GET 
   @Path("/customer/{cid}") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Customer custById(@PathParam("cid") int cust_id){ 
    System.out.println("Finding customer id "+cust_id);
    CustomerDao dao = new CustomerDaoImpl();
    Customer cust = dao.readCustomer(cust_id);
    return cust;
   }
   
   @POST
   @Path("/customer/add") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response makeNewDept(Customer custObj){ 
    System.out.println("Adding a new Customer");
    CustomerDao dao = new CustomerDaoImpl();
    dao.createCustomer(custObj);
    return Response.status(Response.Status.CREATED).entity(custObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   @PUT
   @Path("/customer/update") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response updateDept(Customer custObj){ 
    System.out.println("Editing an existitng Department");
    CustomerDao dao = new CustomerDaoImpl();
    dao.updateCustomer(custObj);
    return Response.status(Response.Status.OK).entity(custObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   
   @GET 
   @Path("/loans") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Loan> allLoans(){ 
       LoanDao dao = new LoanDaoImpl();
    List<Loan> loanList = new ArrayList<Loan>();
    loanList = dao.readLoans();
    return loanList;
   }
   
   @GET 
   @Path("/loan/{lid}") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Loan loanById(@PathParam("lid") int loan_id){ 
    System.out.println("Finding loan id "+loan_id);
    LoanDao dao = new LoanDaoImpl();
    Loan loan = dao.readLoan(loan_id);
    return loan;
   }
   
   @POST
   @Path("/loan/add") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response makeNewLoan(Loan loanObj){ 
    System.out.println("Adding a new loan");
    LoanDao dao = new LoanDaoImpl();
    dao.createLoan(loanObj);
    return Response.status(Response.Status.CREATED).entity(loanObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   @PUT
   @Path("/loan/update") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response updateLoan(Loan loanObj){ 
    System.out.println("Editing an existitng loan");
    LoanDao dao = new LoanDaoImpl();
    dao.updateLoan(loanObj);
    return Response.status(Response.Status.OK).entity(loanObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   @GET 
   @Path("/credentials") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Credentials> allCredentials(){ 
	   CredentialsDao dao = new CredentialsDaoImpl();
    List<Credentials> credList = new ArrayList<Credentials>();
    credList = dao.readCredentials();
    return credList;
   }
   
   @GET 
   @Path("/credential/{username}") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Credentials CredentialByUsername(@PathParam("username") String username){ 
    System.out.println("Finding loan id "+username);
    CredentialsDao dao = new CredentialsDaoImpl();
    Credentials cred = dao.readCredential(username);
    return cred;
   }
   
   @POST
   @Path("/credential/add") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response makeNewCredential(Credentials credObj){ 
    System.out.println("Adding a new credential");
    CredentialsDao dao = new CredentialsDaoImpl();
    dao.createCredentials(credObj);
    return Response.status(Response.Status.CREATED).entity(credObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   @PUT
   @Path("/credential/update") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response updateCredential(Credentials credObj){ 
    System.out.println("Editing an existitng loan");
    CredentialsDao dao = new CredentialsDaoImpl();
    dao.updateCredential(credObj);
    return Response.status(Response.Status.OK).entity(credObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   

   @GET 
   @Path("/vehicles") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Vehicle> allVehicles(){ 
	   VehicleDao dao = new VehicleDaoImpl();
    List<Vehicle> vehList = new ArrayList<Vehicle>();
    vehList = dao.readVehicles();
    return vehList;
   }
   
   @GET 
   @Path("/ vehicle/{vehicle_id}") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Vehicle VehicleById(@PathParam("vehicle_id") int vehicle_id){ 
    System.out.println("Finding loan id "+vehicle_id);
    VehicleDao dao = new VehicleDaoImpl();
    Vehicle veh = dao.readVehicle(vehicle_id);
    return veh;
   }
   
   @POST
   @Path("/vehicle/add") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response makeNewVehicle(Vehicle vehObj){ 
    System.out.println("Adding a new vehicle");
    VehicleDao dao = new VehicleDaoImpl();
    dao.createVehicle(vehObj);
    return Response.status(Response.Status.CREATED).entity(vehObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
   @PUT
   @Path("/vehicle/update") // http://..../resources/DeptService/depts/10
   @Produces(MediaType.APPLICATION_JSON) 
   public Response updateVehicle(Vehicle vehObj){ 
    System.out.println("Editing an existitng loan");
    VehicleDao dao = new VehicleDaoImpl();
    dao.updateVehicle(vehObj);
    return Response.status(Response.Status.OK).entity(vehObj).build();
   // return Response.ok(deptObj,"Object Inserted").build();
   }
   
}