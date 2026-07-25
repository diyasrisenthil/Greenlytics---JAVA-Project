package util;

import model.Shipment;
import model.TransportMode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "data/shipments.txt";

    public static void saveShipment(Shipment shipment) {

        try {

            File folder = new File("data");
            if (!folder.exists()) {
                folder.mkdir();
            }

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(FILE_NAME, true));

            writer.write(shipment.toString());
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving shipment.");
        }

    }

    public static List<Shipment> loadShipments() {

        List<Shipment> shipments = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return shipments;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Shipment shipment = new Shipment(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Double.parseDouble(data[4]),
                        Double.parseDouble(data[5]),
                        TransportMode.valueOf(data[6])
                );

                shipments.add(shipment);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading shipment file.");

        }

        return shipments;
    }
}