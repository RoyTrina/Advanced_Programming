package Labs.Lab3.Exercise2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader in;
        PrintWriter write;
        PrintWriter errors;

        try {
            write = new PrintWriter(new BufferedWriter(new FileWriter("Out.txt")));
            errors = new PrintWriter(new BufferedWriter(new FileWriter("errors.txt")));
            in = new BufferedReader(new FileReader("In.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            write = null;
            errors = null;
            in = null;
            System.exit(1);
        }

        if (args.length == 0) {
            errors.println("Please provide input");
            errors.close();
            System.exit(1);
        } else //noinspection StatementWithEmptyBody
            if (args.length == 1 && args[0].equals("up") || args[0].equals("down")) {

        } else {
            errors.println("Please use one of 'up' or 'down'");
            errors.close();
            System.exit(1);
        }

        String s;

        try {
            while (true) {
                s = in.readLine();
                if (s == null) {
                    break;
                }
                if (args[0].equals("up")) {
                    write.println(s.toUpperCase());
                } else {
                    write.println(s.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        write.close();
        errors.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
