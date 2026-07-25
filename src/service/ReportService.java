package service;

import model.Shipment;
import model.TransportMode;
import util.CarbonCalculator;
import util.CostCalculator;
import util.FileManager;

import java.util.List;

public class ReportService {

    private static final double REVENUE_PER_KM = 8.0;

    public void generateReport() {

        List<Shipment> shipments = FileManager.loadShipments();

        if (shipments.isEmpty()) {

            System.out.println("\nNo shipment records found.");
            return;
        }

        System.out.println("\n====================================================");
        System.out.println("          GREENLYTICS SMART ANALYSIS REPORT");
        System.out.println("====================================================");

        for (Shipment shipment : shipments) {

            double cost = CostCalculator.calculateCost(shipment);
            double emission = CarbonCalculator.calculateEmission(shipment);

            double revenue = shipment.getDistance() * REVENUE_PER_KM;
            double profit = revenue - cost;

            int score = calculateScore(cost, emission);

            TransportMode bestMode = TransportMode.getBestMode(
                    shipment.getDistance(),
                    shipment.getWeight()
            );

            System.out.println("\n--------------------------------------------");
            System.out.println("Shipment ID      : " + shipment.getShipmentId());
            System.out.println("Customer         : " + shipment.getCustomerName());
            System.out.println("Current Mode     : " + shipment.getTransportMode());

            System.out.printf("Transportation Cost : $%.2f%n", cost);
            System.out.printf("CO₂ Emission        : %.2f kg%n", emission);

            System.out.printf("Estimated Revenue   : $%.2f%n", revenue);
            System.out.printf("Estimated Profit    : $%.2f%n", profit);

            System.out.println();

            // Profit Recommendation
            if (profit > 1000) {

                System.out.println("Profitability");
                System.out.println("Highly Profitable");

            } else if (profit > 0) {

                System.out.println("Profitability");
                System.out.println("Profitable");

            } else {

                System.out.println("Profitability");
                System.out.println("Not Profitable");
            }

            System.out.println();

            // Sustainability Score
            System.out.println("Sustainability Score : "
                    + score + "/100");

            if (score >= 90)
                System.out.println("Rating : Excellent");
            else if (score >= 70)
                System.out.println("Rating : Good");
            else if (score >= 50)
                System.out.println("Rating : Average");
            else
                System.out.println("Rating : Poor");

            System.out.println();

            // Recommendation
            System.out.println("Recommended Transport Mode : "
                    + bestMode);

            if (bestMode == shipment.getTransportMode()) {

                System.out.println("Current mode is already optimal.");

            } else {

                System.out.println("Recommendation:");
                System.out.println("- Switch to "
                        + bestMode
                        + " transport.");

                System.out.println("- Lower transportation cost.");

                System.out.println("- Reduce carbon emission.");

                System.out.println("- Improve sustainability.");
            }

            System.out.println("--------------------------------------------");
        }

        System.out.println("\n====================================================");
        System.out.println("Report Generated Successfully");
        System.out.println("====================================================");
    }

    private int calculateScore(double cost, double emission) {

        int score = 100;

        if (cost > 7000)
            score -= 35;
        else if (cost > 4000)
            score -= 20;
        else if (cost > 2000)
            score -= 10;

        if (emission > 5000)
            score -= 35;
        else if (emission > 2000)
            score -= 20;
        else if (emission > 1000)
            score -= 10;

        return Math.max(score, 0);
    }

}