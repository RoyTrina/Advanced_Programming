package Assignment.Helpers.ServerSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//This is the client_handler file
public class Customer_handler implements Runnable {
    private final Socket socket;
    private final CafeSystem cafeSystem;
    private final Random number_generator = new Random();

    public Customer_handler(Socket socket, CafeSystem server) {
        this.cafeSystem = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Scanner scan = new Scanner(socket.getInputStream());
             PrintWriter access = new PrintWriter(socket.getOutputStream(), true)) {
            try {
                int customerID = number_generator.nextInt(100);
                System.out.println("New connection; customerID" + customerID);
                if (cafeSystem.getAllAccounts().size() == 0) {
                    throw new Exception("Unknown customer: " + customerID + ".");
                }
                access.println("SUCCESS");
                do {
                    String line = scan.nextLine();
                    String[] sub_strings = line.split(" ");
                    switch (sub_strings[0].toLowerCase()) {
                        case "view_menu":
                            System.out.println("These are the drinks available:");

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

                        case "orders":
                            System.out.println("These are all the orders stored in the server:");
                            cafeSystem.viewAllOrders();

                        case "accounts":
                            System.out.println("");
                            cafeSystem.getAllAccounts();

                        case "order status":
                            System.out.println("");
                            cafeSystem.viewOrderStatus();
                    }


                } while (true);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}