package vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class VehicleDaoTest {

    private VehicleDao vehicleDao;

    @BeforeEach
    public void init() {
        vehicleDao = new VehicleDaoImpl(); // Initialize the DAO implementation
    }

    @Test
    public void testReadAllVehicles() { // Test to read all vehicles
        List<Vehicle> vehicleList = vehicleDao.readVehicles();
        Assertions.assertNotNull(vehicleList);
        System.out.println("Vehicle details are extracted...");
        Assertions.assertTrue(vehicleList.size() > 0);
        for (Vehicle vehicle : vehicleList) {
            System.out.println("Vehicle: " + vehicle);
        }
    }

    @Test
    public void testReadVehicle() { // Test to read a single vehicle
        Vehicle vehicle = vehicleDao.readVehicle(2001); // Use an ID that exists in your test database
        Assertions.assertNotNull(vehicle);
        System.out.println("Vehicle record has been extracted...");
        Assertions.assertEquals(vehicle.getVehicle_id(), 2001);
        Assertions.assertEquals(vehicle.getMake(), "4-Wheeler");
        Assertions.assertEquals(vehicle.getModel(), "Toyota Camry");
        Assertions.assertEquals(vehicle.getEx_showroom_price(), 2500000);
        Assertions.assertEquals(vehicle.getOn_road_price(), 2750000);
        Assertions.assertEquals(vehicle.getCust_id(), 1001);
        System.out.println("All records are correct");
    }

    @Test
    public void testCreateVehicle() { // Test to insert a new vehicle
        Vehicle vehicle = new Vehicle();
        int testId = 0; // Use a unique ID for testing
        String testMake = "testmake";
        String testModel = "testmodel";
        int testExShowroomPrice = 0;
        int testOnRoadPrice = 0;
        int testCustId = 1001;

        vehicle.setVehicle_id(testId);
        vehicle.setMake(testMake);
        vehicle.setModel(testModel);
        vehicle.setEx_showroom_price(testExShowroomPrice);
        vehicle.setOn_road_price(testOnRoadPrice);
        vehicle.setCust_id(testCustId);

        List<Vehicle> vehicleList = vehicleDao.readVehicles();
        int initialSize = vehicleList.size();
        vehicleDao.createCredentials(vehicle);
        vehicleList = vehicleDao.readVehicles();
        int currentSize = vehicleList.size();
        Assertions.assertEquals(initialSize + 1, currentSize);
        System.out.println("Vehicle added successfully: " + vehicle);

        Vehicle retrievedVehicle = vehicleDao.readVehicle(testId);
        Assertions.assertEquals(retrievedVehicle.getVehicle_id(), vehicle.getVehicle_id());
        Assertions.assertEquals(retrievedVehicle.getMake(), vehicle.getMake());
        Assertions.assertEquals(retrievedVehicle.getModel(), vehicle.getModel());
        Assertions.assertEquals(retrievedVehicle.getEx_showroom_price(), vehicle.getEx_showroom_price());
        Assertions.assertEquals(retrievedVehicle.getOn_road_price(), vehicle.getOn_road_price());
        Assertions.assertEquals(retrievedVehicle.getCust_id(), vehicle.getCust_id());
        System.out.println("Data is matching");
    }

    @Test
    public void testUpdateVehicle() { // Test to update an existing vehicle
        Vehicle vehicle = new Vehicle();
        int testId = 0; // Use an ID that exists in your test database
        String testMake = "testmake1";
        String testModel = "testmake2";
        int testExShowroomPrice = 1;
        int testOnRoadPrice = 1;

        vehicle.setVehicle_id(testId);
        vehicle.setMake(testMake);
        vehicle.setModel(testModel);
        vehicle.setEx_showroom_price(testExShowroomPrice);
        vehicle.setOn_road_price(testOnRoadPrice);
        // Leave out cust_id if it is not being updated in the update query

        vehicleDao.updateVehicle(vehicle);
        System.out.println("Vehicle data updated...");
        Vehicle updatedVehicle = vehicleDao.readVehicle(testId);

        Assertions.assertEquals(updatedVehicle.getVehicle_id(), vehicle.getVehicle_id());
        Assertions.assertEquals(updatedVehicle.getMake(), vehicle.getMake());
        Assertions.assertEquals(updatedVehicle.getModel(), vehicle.getModel());
        Assertions.assertEquals(updatedVehicle.getEx_showroom_price(), vehicle.getEx_showroom_price());
        Assertions.assertEquals(updatedVehicle.getOn_road_price(), vehicle.getOn_road_price());
        System.out.println("Data is matching");
    }

    @Test
    public void testDeleteVehicle() { // Test to delete a vehicle
        int testId = 0; // Use an ID that exists in your test database
        List<Vehicle> vehicleList = vehicleDao.readVehicles();
        int initialSize = vehicleList.size();
        vehicleDao.deleteVehicle(testId);
        vehicleList = vehicleDao.readVehicles();
        int currentSize = vehicleList.size();
        Assertions.assertEquals(initialSize - 1, currentSize);
        System.out.println("Vehicle has been deleted");
    }
}
