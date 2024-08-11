package vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VehicleDaoImpl implements VehicleDao {
	
	Connection conn=null;
    
	public VehicleDaoImpl() {
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
	public void createCredentials(Vehicle vehObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into vehicle values (?,?,?,?,?,?)");
			pst.setInt(1,vehObj.getVehicle_id());
			pst.setString(2, vehObj.getMake());
			pst.setString(3, vehObj.getModel());
			pst.setInt (4,vehObj.getEx_showroom_price());
			pst.setInt(5,vehObj.getOn_road_price());
			pst.setInt(6,vehObj.getCust_id());
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) inserted : ");
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Vehicle readVehicle(int vehicle_id) {
		Vehicle veh = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from vehicle where vehicle_id="+vehicle_id);
			if(result.next()) {
				veh = new Vehicle();
				veh.setVehicle_id(result.getInt(1));
				veh.setMake(result.getString(2));
				veh.setModel(result.getString(3));
				veh.setEx_showroom_price(result.getInt(4));
				veh.setOn_road_price(result.getInt(5));
				veh.setCust_id(result.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return veh;
	}

	@Override
	public List<Vehicle> readVehicles() {
		
		Vehicle veh = null;
		ArrayList<Vehicle> vehList = new ArrayList<Vehicle>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from vehicle");
			
			while(result.next()) {
				veh = new Vehicle();
				veh.setVehicle_id(result.getInt(1));
				veh.setMake(result.getString(2));
				veh.setModel(result.getString(3));
				veh.setEx_showroom_price(result.getInt(4));
				veh.setOn_road_price(result.getInt(5));
				veh.setCust_id(result.getInt(6));
				vehList.add(veh);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehList;
		
	}

	@Override
	public void updateVehicle(Vehicle vehObj) {
		try {
			PreparedStatement pst = conn.prepareStatement("update vehicle set make=?,model=?,ex_showroom_price=?,on_road_price=? where vehicle_id=?");
			
			pst.setInt(5,vehObj.getVehicle_id()); //WHERE
			pst.setString(1, vehObj.getMake()); 
			pst.setString(2, vehObj.getModel()); 
			pst.setInt(3, vehObj.getEx_showroom_price());
			pst.setInt(4, vehObj.getOn_road_price()); 
			//pst.setInt(5, vehObj.getCust_id()); 
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) updated : ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVehicle(int vehicle_id) {
		
		try {
			PreparedStatement pst = conn.prepareStatement("delete from vehicle where vehicle_id=?");
			
			pst.setInt(1,vehicle_id); //WHERE
			
			int rows = pst.executeUpdate();
			System.out.println(rows+" Record(s) deleted : ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
