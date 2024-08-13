package com.vlc.dao;

import java.util.List;

public interface VehicleDao {
	void             createVehicle(Vehicle vehObj);
	Vehicle 	     readVehicle(int cust_id);
	List<Vehicle>    readVehicles();
	void             updateVehicle(Vehicle vehObj);
	void 			 deleteVehicle(int vehicle_id);

}
