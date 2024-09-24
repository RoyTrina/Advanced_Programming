package Labs.Lab1.Solutions.Exercise2.Q2;

public class Main
{
    public static void main( String [] args )
    {
        int [] plist = {1, 2, 3, 4, 5};
        int [] newline = IntListProcessor.process( plist, x -> x+2 );

        for (int i = 0; i < newline.length - 1; i++) System.out.print( newline[i] + ", " );
        System.out.println( newline[ newline.length - 1 ] );
    }
}
