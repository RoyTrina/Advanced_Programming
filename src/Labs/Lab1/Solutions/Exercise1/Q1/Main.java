package Labs.Lab1.Solutions.Exercise1.Q1;

import Labs.Lab1.Exercise1.Q1.MyPredicate;
import Labs.Lab1.Exercise1.Q1.SelectPositive;

public class Main
{
    public static void printSelected(int[] list, MyPredicate select){
        for (int element : list)
            if (select.apply(element))
                System.out.println(element);
    }

    public static void main (String[] args){
        int[] list = {1, 2, -5, -4, 0, 6};
        printSelected(list, new SelectPositive());
    }
}
