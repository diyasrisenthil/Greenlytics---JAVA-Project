package test;

import service.LoginService;
import service.ShipmentService;

public class Test {

    public static void main(String[] args) {

        LoginService loginService = new LoginService();

        if (loginService.login()) {

            ShipmentService shipmentService = new ShipmentService();

            shipmentService.addShipment();

            shipmentService.viewShipments();

            shipmentService.searchShipment();

        } else {

            System.out.println("Login Failed!");

        }
    }
}