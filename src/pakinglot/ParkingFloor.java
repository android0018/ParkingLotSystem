package pakinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private int floorNumber;

    public  ParkingFloor(int floorNumber,int numOfCarSpots,int numOfBikeSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();

        for (int i = 0; i < numOfCarSpots; i++) {
            this.spots.add(new CarParkingSpot(i + 1));
        }
        for (int i = numOfCarSpots; i < numOfCarSpots+numOfBikeSpots; i++) {
            this.spots.add(new BikeParkingSpot(i + 1));
        }
    }

    public ParkingSpot findAvailableSpot(String vehicleType){
        for(ParkingSpot spot : spots){
            if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)){
                return spot;
            }
        }
        return null;
    }
    List<ParkingSpot> getParkingSpots(){
        return spots;
    }

}
