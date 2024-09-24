import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        int[] multThrees = IntStream.iterate(0, i -> i + 3)
                .limit(5)
                .toArray();

        System.out.println(Arrays.toString(multThrees));

        var obj1 = new GenericClass<Integer>();
        var obj2 = new GenericClass<Integer>();
        var obj3 = new GenericClass<String>();
        System.out.println(obj1);


        Stream<Integer> stream  = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        System.out.println( Stream.concat(stream, stream2)
                .filter(x -> x >= 3)
                .count()
        );

        Stream<Integer> myStream = Stream.of(3,1,4,1,5);
        Map<Boolean, List<Integer>> partition = myStream.collect(
                Collectors.partitioningBy(i -> i % 2 == 0)
        );
    }

    static class GenericClass<T> {
        static int counter;

        GenericClass() {
            counter++;
        }

        @Override
        public String toString() {
            return getClass() + ": " + counter + " instances created.";
        }

    }

}
