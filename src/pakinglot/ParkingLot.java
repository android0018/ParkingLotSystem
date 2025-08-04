package pakinglot;

import vehicles.Vehicle;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;
    public ParkingLot(List<ParkingFloor> floors){
        this.floors=floors;
    }

    public ParkingSpot findAvailableSpot(String vehicleType){
        for(ParkingFloor floor:floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicleType);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if(spot!=null){
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot:"+spot.getSpotNumber());
            return spot;
        }
        System.out.println("No parking available right now for"+ vehicle.getVehicleType()+ "!");
        return null;
    }

    public void vacateVehicle(ParkingSpot spot,Vehicle vehicle){
        if(spot!=null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
            spot.vacate();
            System.out.println(vehicle.getVehicleType()+"vacated the spot:"+spot.getSpotNumber());
        }
        else {
            System.out.println("Invalid Operation! either spot is already vacant or the vehicle doesn't match");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNumber){
        for(ParkingFloor floor:floors){
            for(ParkingSpot spot: floor.getParkingSpots()){
                if(spot.getSpotNumber()==spotNumber){
                    return spot;
                }
            }
        }
        return null;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}
