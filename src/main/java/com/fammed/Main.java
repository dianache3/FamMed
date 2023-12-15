package main.java.com.fammed;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String password = "pass";
    static Scanner scanner = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static void main(String[] args) {
        run();}

    static void run(){
        if (auth()){
           registerNewClient();
        }
    }
        static boolean auth() {
            boolean accepted = false;
            for (int i = 0; i < 3; i++) {
                System.out.print("Password: ");
                String input = scanner.nextLine();

                if (password.equals(input)) {
                    accepted = true;
                    break;
                } else {
                    System.out.println("Access denied. Please check your password.");
                }
            }
            System.out.println(accepted ? "Welcome to the FamMed!" : "Application has benn blocked.");

            return accepted;
        }
        static void registerNewClient() {
            System.out.println("Please provide client details.");
            System.out.print("Email: ");
            String email = scanner.nextLine();

            if (isEmailValid(email)){
                Client client = buildClient(email);
                System.out.println("New client: " + client.firstName + " "
                        + client.lastName + " (" + client.email + ")");
            } else {
                System.out.println("Provided email is invalid.");
            }
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        System.out.print("First name: ");
        client.firstName = scanner.nextLine();

        System.out.print("Last name: ");
        client.lastName = scanner.nextLine();

        return client;
    }
}
