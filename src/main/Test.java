package test;

import service.LoginService;
import service.ReportService;
import service.ShipmentService;

public class Test {

    public static void main(String[] args) {

        LoginService loginService = new LoginService();

        if (loginService.login()) {

            ShipmentService shipmentService = new ShipmentService();
            ReportService reportService = new ReportService();

            // shipmentService.addShipment();

            shipmentService.viewShipments();

            shipmentService.searchShipment();

            reportService.generateReport();

        } else {

            System.out.println("Login Failed!");
        }
    }
}