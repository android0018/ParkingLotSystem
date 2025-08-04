package vehicles;

public class BikeVehicle extends Vehicle{
    private static final double RATE=5.0;

    public BikeVehicle(String licensePlate){
        super(licensePlate,"Bike");
    }

    @Override
    public double calculateFee(int hoursStayed){
        return hoursStayed*RATE;
    }
}
