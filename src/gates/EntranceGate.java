package gates;

import pakinglot.ParkingLot;
import pakinglot.ParkingSpot;
import vehicles.Vehicle;
import vehicles.VehicleFactory;

import java.util.Scanner;

public class EntranceGate {
    private ParkingLot parkingLot;

    public EntranceGate(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }

    public void processEntrance(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter your vehicle's license number");
        String licensePlate= scanner.next();
        System.out.println("Please enter your vehicle type(Car or Bike):");
        String vehicleType= scanner.next();

        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType,licensePlate);
        if(vehicle==null){
            System.out.println("Invalid vehicle type entered! Only Car and Bike are allowed");
            return;
        }

        ParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);
        if(parkingSpot!=null){
            System.out.println("Vehicle parked successfully in spot:" + parkingSpot.getSpotNumber());
        }
        else {
            System.out.println("No available spots found for this vehicle type");
        }
    }
}
