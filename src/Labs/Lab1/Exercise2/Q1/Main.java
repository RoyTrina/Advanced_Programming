package Labs.Lab1.Exercise2.Q1;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    protected Predicate<Integer> select;

    public static void printSelected(int[] list, Function<Integer, Boolean> select) {
        for (int element : list)
            if (select.apply(element))
                System.out.println(element);
    }

    public static void main(String[] args) {
        int[] list = {9, 2, -5, -4, 0, 6};

        printSelected(list, x -> x > 0);
    }
}
