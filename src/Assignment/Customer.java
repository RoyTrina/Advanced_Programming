package Assignment;


import Assignment.Helpers.ClientSide.CustomerAccount;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//The Customer class is the ClientProgram
public class Customer implements AutoCloseable {
    public static PrintWriter console_writer;
    public static final Scanner console_reader = new Scanner(System.in);



    public static void main(String[] args) {

        //Setting up and login
        try (CustomerAccount new_customer = new CustomerAccount()) {
            System.out.println("Hello, how would you like to login?");
            System.out.println("ID or by name?");
            String response = console_reader.nextLine();

            if (response.contains("ID")) {
                int integer_response = Integer.parseInt(response);
                System.out.println("You are logged in by ID. Your ID is: " + integer_response);
                console_writer.println("Your ID is: " + new_customer.setCustomerID());
            } else {
                System.out.println("Please enter your username: ");
                String username = console_reader.nextLine();
                String regex = "^[A-Z|a-z][A-Z|a-z\\\\d_]{7,29}$";

                if (username.matches(regex)) {
                    console_writer.println("You are logged in by your username. Your username is: " + username);
                } else {
                    System.out.println("Please try again.");
                }

                //Getting the user to choose what they want to do
                System.out.println("What would you like to do, " + username + "?");
                String answer = console_reader.nextLine();

                if (answer.equals("order drinks")) {
                    String orderDrinks = console_reader.nextLine();
                    System.out.println(Arrays.toString(orderDrinks.split(" ")));

                } else if (answer.equals("order status")) {
                    System.out.println("Hello");

                } else {

                }

            }


            //
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void close() {
        console_writer.close();
        console_reader.close();
    }
}
