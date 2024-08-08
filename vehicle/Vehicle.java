package vehicle;

public class Vehicle {
	int vehicle_id ;
    String make; 
    String model;
    int ex_showroom_price ;
    int on_road_price ;
    int cust_id;
    
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEx_showroom_price() {
		return ex_showroom_price;
	}
	public void setEx_showroom_price(int ex_showroom_price) {
		this.ex_showroom_price = ex_showroom_price;
	}
	public int getOn_road_price() {
		return on_road_price;
	}
	public void setOn_road_price(int on_road_price) {
		this.on_road_price = on_road_price;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
    
}
