package utils;

import vehicles.Vehicle;

public class FeeCalculator {
    public static double calculateFee(int hours, Vehicle vehicle){
        return vehicle.calculateFee(hours);
    }
}
