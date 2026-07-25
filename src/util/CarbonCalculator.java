package util;

import model.Shipment;

public class CarbonCalculator {

    public static double calculateEmission(Shipment shipment) {

        double factor = shipment.getTransportMode().getEmissionFactor();

        return shipment.getDistance()
                * shipment.getWeight()
                * factor;
    }
}