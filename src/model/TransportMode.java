package model;

public enum TransportMode {

    ROAD(5.0, 0.11),
    RAIL(3.5, 0.04),
    SEA(2.0, 0.01),
    AIR(10.0, 0.50);

    private final double costPerKm;
    private final double emissionFactor;

    TransportMode(double costPerKm, double emissionFactor) {
        this.costPerKm = costPerKm;
        this.emissionFactor = emissionFactor;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public double getEmissionFactor() {
        return emissionFactor;
    }
}