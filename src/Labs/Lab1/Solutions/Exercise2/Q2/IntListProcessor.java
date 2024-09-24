package Labs.Lab1.Solutions.Exercise2.Q2;

import java.util.function.Function;

public class IntListProcessor
{
    public static int [] process( int [] list, Function<Integer,Integer> processor )
    {
        int [] newline = new int [list.length];
        for (int i = 0; i < list.length; i++)
        {
            newline[i] = processor.apply( list[i] );
        }

        return newline;
    }
}
