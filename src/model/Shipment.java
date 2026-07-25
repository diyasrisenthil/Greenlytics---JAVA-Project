package model;

public class Shipment {

    private int shipmentId;
    private String customerName;
    private String source;
    private String destination;
    private double distance;
    private double weight;
    private TransportMode transportMode;

    public Shipment() {
    }

    public Shipment(int shipmentId,
                    String customerName,
                    String source,
                    String destination,
                    double distance,
                    double weight,
                    TransportMode transportMode) {

        this.shipmentId = shipmentId;
        this.customerName = customerName;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.weight = weight;
        this.transportMode = transportMode;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    @Override
    public String toString() {

        return shipmentId + "," +
                customerName + "," +
                source + "," +
                destination + "," +
                distance + "," +
                weight + "," +
                transportMode;
    }
}