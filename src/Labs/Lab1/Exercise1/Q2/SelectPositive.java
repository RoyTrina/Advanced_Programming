package Labs.Lab1.Exercise1.Q2;

import Labs.Lab1.Exercise1.Q1.MyPredicate;

public class SelectPositive implements MyPredicate {
    @Override
    public boolean apply(int value) {
        return value > 0;
    }
}
