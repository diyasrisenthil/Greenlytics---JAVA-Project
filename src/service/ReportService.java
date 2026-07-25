package service;

import model.Shipment;
import util.CarbonCalculator;
import util.CostCalculator;
import util.FileManager;

import java.util.List;

public class ReportService {

    public void generateReport() {

        List<Shipment> shipments = FileManager.loadShipments();

        if (shipments.isEmpty()) {
            System.out.println("\nNo shipment records found.");
            return;
        }

        double totalCost = 0;
        double totalEmission = 0;

        Shipment highestCostShipment = shipments.get(0);
        Shipment highestEmissionShipment = shipments.get(0);

        System.out.println("\n========== GREENLYTICS REPORT ==========\n");

        for (Shipment shipment : shipments) {

            double cost = CostCalculator.calculateCost(shipment);
            double emission = CarbonCalculator.calculateEmission(shipment);

            totalCost += cost;
            totalEmission += emission;

            if (cost > CostCalculator.calculateCost(highestCostShipment)) {
                highestCostShipment = shipment;
            }

            if (emission > CarbonCalculator.calculateEmission(highestEmissionShipment)) {
                highestEmissionShipment = shipment;
            }

            System.out.println("-----------------------------------------");
            System.out.println("Shipment ID : " + shipment.getShipmentId());
            System.out.println("Customer    : " + shipment.getCustomerName());
            System.out.println("Mode        : " + shipment.getTransportMode());
            System.out.printf("Cost        : $%.2f%n", cost);
            System.out.printf("CO₂ Emission: %.2f kg%n", emission);
        }

        System.out.println("\n=========================================");
        System.out.printf("Total Transportation Cost : $%.2f%n", totalCost);
        System.out.printf("Total CO₂ Emission        : %.2f kg%n", totalEmission);

        System.out.println("\nHighest Cost Shipment");
        System.out.println("Shipment ID : " + highestCostShipment.getShipmentId());
        System.out.println("Customer    : " + highestCostShipment.getCustomerName());

        System.out.println("\nHighest CO₂ Emission Shipment");
        System.out.println("Shipment ID : " + highestEmissionShipment.getShipmentId());
        System.out.println("Customer    : " + highestEmissionShipment.getCustomerName());

        System.out.println("\n========== END OF REPORT ==========");
    }
}