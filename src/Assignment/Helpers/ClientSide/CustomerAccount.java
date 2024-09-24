package Assignment.Helpers.ClientSide;


import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//This is the Client file
public class CustomerAccount implements AutoCloseable {
    final int port = 8083;
    final Random number_generator = new Random();
    private PrintWriter console_writer = null;
    public static Scanner console_reader = new Scanner(System.in);
    int customerID;

    private int numberOfDrinks;


    public CustomerAccount() {
        try (Socket newSocket = new Socket("localhost", port)) {
            console_reader = new Scanner(newSocket.getInputStream());
            console_writer = new PrintWriter(newSocket.getOutputStream(), true);
            String line = console_reader.nextLine();
            if (line.trim().compareToIgnoreCase("success") != 0) {
                throw new Exception(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] getCustomerAccountIDs() {
        console_writer.println("CUSTOMER IDs");
        String line = String.valueOf(number_generator.nextInt(100));
        int numberOfIDs = Integer.parseInt(line);
        int[] numberOfID_array = new int[numberOfIDs];
        for (int i = 0; i < numberOfIDs; i++) {
            line = console_reader.nextLine();
            numberOfID_array[i] = Integer.parseInt(line);
        }
        return numberOfID_array;
    }

    public ArrayList<String> choose_Drinks() {
        console_writer.println("VIEW MENU");
        ArrayList<String> view_menu = new ArrayList<>(10);

        view_menu.add(1, "Cappuccino");
        view_menu.add(2, "Espresso");
        view_menu.add(3, "Caffe Latte");
        view_menu.add(4, "Macchiato");
        view_menu.add(5, "Masala chai");
        view_menu.add(6, "Ginger chai");
        view_menu.add(7, "Bombay cutting chai");
        view_menu.add(8, "Kashmiri kahwa");
        view_menu.add(9, "Coffee");
        view_menu.add(10, "Tea");

        return view_menu;
    }

    public int setCustomerID() {
        this.customerID = number_generator.nextInt(100);
        return customerID;
    }


    public String[] getOrders(int ID) {
        console_writer.println("GET ORDERS");
        return new String[0];
    }

    public void setOrder(int numberOfDrinks, String drinks) {
        this.numberOfDrinks = numberOfDrinks;

    }

    @Override
    public void close() {
        console_writer.close();
        console_reader.close();
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }

    public void setNumberOfDrinks(int numberOfDrinks) {
        this.numberOfDrinks = numberOfDrinks;
    }
}
