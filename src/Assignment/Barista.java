package Assignment;

import Assignment.Helpers.ServerSide.CafeSystem;
import Assignment.Helpers.ServerSide.Customer_handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

//The Barista is the serverProgram
public class Barista implements AutoCloseable {
    private final static int port = 8083;
    private final static CafeSystem server = new CafeSystem();
    public static Scanner console_reader;

    //waiting area data structure
    private final Stack<String> waiting_area = new Stack<>();

    //brewing area data structure
    private final Queue<String> brewing_area = new ConcurrentLinkedQueue<>();

    //tray area data structure
    private final ArrayList<String> tray_area = new ArrayList<>();

    public Barista() {
    }


    public static void main(String[] args) {
        server.createOrder( 1, "order 2 masala chai");
        server.createOrder( 2, "order 4 coffee");
        server.createOrder( 3, "order 9 ginger chai");
        server.createOrder( 4, "order 1 tea");
        server.createOrder( 5, "order ");
        server.createOrder( 6, "order ");

        runSystem();
    }

    private static void runSystem() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Loading...");
            do {
                Socket socket = serverSocket.accept();
                new Thread(new Customer_handler(socket, server)).start();
            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        console_reader.close();

    }

    public Stack<String> getWaiting_area() {
        return waiting_area;
    }

    public Queue<String> getBrewing_area() {
        return brewing_area;
    }

    public ArrayList<String> getTray_area() {
        return tray_area;
    }
}
