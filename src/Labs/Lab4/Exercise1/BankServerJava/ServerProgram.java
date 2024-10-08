package Labs.Lab4.Exercise1.BankServerJava;// ServerProgram.java

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {
    private final static int port = 8888;
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        bank.createAccount(1, 1001, 100);
        bank.createAccount(1, 1002, 200);
        bank.createAccount(2, 1003, 150);
        bank.createAccount(3, 1004, 50);
        RunServer();
    }

    private static void RunServer() {
        ServerSocket serverSocket;   // passive socket, used for 'listening'
        try {
            serverSocket = new ServerSocket(port);  // bind port and start listening
            System.out.println("Waiting for incoming connections...");
            while (true) {
                Socket socket = serverSocket.accept();  // accept incoming connections (blocks until it does!)
                new Thread(new ClientHandler(socket, bank)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
