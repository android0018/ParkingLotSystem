package pakinglot;

import vehicles.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String spotType;
    public ParkingSpot(int spotNumber,String spotType){
        this.isOccupied=false;
        this.spotNumber=spotNumber;
        this.spotType=spotType;
    }
    public boolean isOccupied(){
        return isOccupied;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle){
        if(isOccupied){
            throw new IllegalArgumentException("Spot is already occupied");
        }
        if(!canParkVehicle(vehicle)){
            throw new IllegalArgumentException("This spot is not suitable for a"+ vehicle.getVehicleType()
            );
        }
        this.vehicle=vehicle;
        this.isOccupied=true;
    }

    public void vacate(){
        if(!isOccupied){
            throw new IllegalArgumentException("Spot is already vacant");
        }
        this.isOccupied=false;
        this.vehicle=null;
    }
    public int getSpotNumber(){
        return spotNumber;
    }
    public String getSpotType(){
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
