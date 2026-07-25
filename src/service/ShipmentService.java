package service;

import exception.InvalidShipmentException;
import model.Shipment;
import model.TransportMode;
import util.FileManager;
import util.Validator;

import java.util.List;
import java.util.Scanner;

public class ShipmentService {

    private final Scanner scanner = new Scanner(System.in);

    public void addShipment() {

        try {

            System.out.println("\n===== ADD SHIPMENT =====");

            System.out.print("Shipment ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer Name : ");
            String customer = scanner.nextLine();

            System.out.print("Source : ");
            String source = scanner.nextLine();

            System.out.print("Destination : ");
            String destination = scanner.nextLine();

            System.out.print("Distance (km): ");
            double distance = scanner.nextDouble();

            System.out.print("Weight (tonnes): ");
            double weight = scanner.nextDouble();

            scanner.nextLine();

            System.out.println("\nSelect Transport Mode");
            System.out.println("1. ROAD");
            System.out.println("2. RAIL");
            System.out.println("3. SEA");
            System.out.println("4. AIR");

            System.out.print("Choice : ");

            int choice = scanner.nextInt();

            TransportMode mode;

            switch (choice) {
                case 1:
                    mode = TransportMode.ROAD;
                    break;
                case 2:
                    mode = TransportMode.RAIL;
                    break;
                case 3:
                    mode = TransportMode.SEA;
                    break;
                case 4:
                    mode = TransportMode.AIR;
                    break;
                default:
                    System.out.println("Invalid Transport Mode.");
                    return;
            }

            Validator.validateShipment(id, customer, distance, weight);

            Shipment shipment = new Shipment(
                    id,
                    customer,
                    source,
                    destination,
                    distance,
                    weight,
                    mode
            );

            FileManager.saveShipment(shipment);

            System.out.println("\nShipment Added Successfully!");

        } catch (InvalidShipmentException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid Input.");
        }

    }

    public void viewShipments() {

        List<Shipment> shipments = FileManager.loadShipments();

        if (shipments.isEmpty()) {

            System.out.println("\nNo Shipments Found.");
            return;
        }

        System.out.println("\n========== ALL SHIPMENTS ==========");

        for (Shipment s : shipments) {

            System.out.println("--------------------------------");
            System.out.println("Shipment ID : " + s.getShipmentId());
            System.out.println("Customer    : " + s.getCustomerName());
            System.out.println("Source      : " + s.getSource());
            System.out.println("Destination : " + s.getDestination());
            System.out.println("Distance    : " + s.getDistance());
            System.out.println("Weight      : " + s.getWeight());
            System.out.println("Mode        : " + s.getTransportMode());
        }
    }

    public void searchShipment() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter Shipment ID : ");

        int id = scanner.nextInt();

        List<Shipment> shipments = FileManager.loadShipments();

        for (Shipment s : shipments) {

            if (s.getShipmentId() == id) {

                System.out.println("\nShipment Found");
                System.out.println("---------------------");
                System.out.println("Customer : " + s.getCustomerName());
                System.out.println("Source : " + s.getSource());
                System.out.println("Destination : " + s.getDestination());
                System.out.println("Distance : " + s.getDistance());
                System.out.println("Weight : " + s.getWeight());
                System.out.println("Mode : " + s.getTransportMode());

                return;
            }
        }

        System.out.println("Shipment Not Found.");
    }

}