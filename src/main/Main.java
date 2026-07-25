package main;

import model.Shipment;
import model.TransportMode;

public class Main {

    public static void main(String[] args) {

        Shipment shipment = new Shipment(
                101,
                "Sandhiya",
                "Chennai",
                "Bangalore",
                350,
                1200,
                TransportMode.ROAD
        );

        System.out.println("Shipment Created Successfully!");
        System.out.println(shipment);
    }
}