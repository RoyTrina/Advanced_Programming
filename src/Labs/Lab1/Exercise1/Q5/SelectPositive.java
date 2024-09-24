package Labs.Lab1.Exercise1.Q5;

public class SelectPositive implements Labs.Lab1.Exercise1.Q1.MyPredicate {
    @Override
    public boolean apply(int value) {
        return value > 0;
    }
}
