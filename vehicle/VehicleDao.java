package vehicle;

import java.util.List;

public interface VehicleDao {
	void             createCredentials(Vehicle vehObj);
	Vehicle 	     readVehicle(int vehicle_id);
	List<Vehicle>    readVehicles();
	void             updateVehicle(Vehicle vehObj);
	void 			 deleteVehicle(int vehicle_id);

}
