import gates.EntranceGate;
import gates.ExitGate;
import pakinglot.ParkingFloor;
import pakinglot.ParkingLot;
import pakinglot.ParkingSpot;
import payment.PaymentService;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParkingFloor parkingFloor = new ParkingFloor(1,2,2);
        ArrayList<ParkingFloor> floors= new ArrayList<>();
        floors.add(parkingFloor);
        ParkingLot parkingLot = new ParkingLot(floors);

        PaymentService paymentService= new PaymentService(scanner);
        EntranceGate entranceGate = new EntranceGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot,paymentService);

        boolean exit=false;
        while(!exit){
            showMenu();
            int choice=scanner.nextInt();

            switch(choice) {
                case 1:
                    parkVehicle(entranceGate);
                    break;
                case 2:
                    vacateVehicle(exitGate,scanner);
                    break;
                case 3:
                    exit=true;
                    System.out.println("Thank-you for using the Parking Lot system");
                    break;
                case 4:
                    System.out.println("Invalid option! Please try again");
                    break;
            }
        }
        scanner.close();
    }

    private static void showMenu(){
        System.out.println("\n******************************************************");
        System.out.println("Please choose an option from below:");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Vacate a vehicle spot");
        System.out.println("3. Exit the system");
        System.out.println("******************************************************");
    }

    private static void parkVehicle(EntranceGate entranceGate) {
        entranceGate.processEntrance();
    }

    private static void vacateVehicle(ExitGate exitGate, Scanner scanner) {
        System.out.println("Enter the spot number to vacate: ");
        int spotNumber = scanner.nextInt();
        System.out.println("Enter the number of hours the vehicle stayed: ");
        int hoursStayed = scanner.nextInt();
        exitGate.processExit(spotNumber, hoursStayed);
    }
}