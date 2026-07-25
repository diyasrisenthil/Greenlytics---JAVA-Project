package util;

import exception.InvalidShipmentException;

public class Validator {

    public static void validateShipment(int id, String customerName,
                                        double distance, double weight)
            throws InvalidShipmentException {

        if (id <= 0) {
            throw new InvalidShipmentException("Shipment ID must be positive.");
        }

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidShipmentException("Customer name cannot be empty.");
        }

        if (distance <= 0) {
            throw new InvalidShipmentException("Distance must be greater than 0.");
        }

        if (weight <= 0) {
            throw new InvalidShipmentException("Weight must be greater than 0.");
        }
    }
}