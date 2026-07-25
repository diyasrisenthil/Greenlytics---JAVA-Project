package service;

import java.util.Scanner;

public class LoginService {

    // Default Credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "green123";

    public boolean login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("        GREENLYTICS LOGIN");
        System.out.println("==================================");

        System.out.print("Enter Username : ");
        String username = scanner.nextLine();

        System.out.print("Enter Password : ");
        String password = scanner.nextLine();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            System.out.println("\n Login Successful!\n");
            return true;

        } else {

            System.out.println("\n Invalid Username or Password.");
            return false;
        }
    }
}