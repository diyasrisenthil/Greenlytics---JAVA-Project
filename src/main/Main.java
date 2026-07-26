package main;

import service.LoginService;
import service.ReportService;
import service.ShipmentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LoginService loginService = new LoginService();
        ShipmentService shipmentService = new ShipmentService();
        ReportService reportService = new ReportService();

        System.out.println("====================================");
        System.out.println("       GREENLYTICS SYSTEM");
        System.out.println("====================================");

        if (!loginService.login()) {
            System.out.println("Exiting Application...");
            return;
        }

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("            MAIN MENU");
            System.out.println("====================================");
            System.out.println("1. Add Shipment");
            System.out.println("2. View Shipments");
            System.out.println("3. Search Shipment");
            System.out.println("4. Generate Smart Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    shipmentService.addShipment();
                    break;

                case 2:
                    shipmentService.viewShipments();
                    break;

                case 3:
                    shipmentService.searchShipment();
                    break;

                case 4:
                    reportService.generateReport();
                    break;

                case 5:
                    System.out.println("\nThank you for using Greenlytics!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}