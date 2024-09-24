package Labs.Lab2.Solutions.Exercise2.Q1;

public class InterferenceChecker_WithSynchronizedBlock implements Runnable {

    public static int    shared;
    public static final Object lock        = new Object();
    final  static int    REPETITIONS = 1000 * 1000;

    public final int id;


    InterferenceChecker_WithSynchronizedBlock( int id ) { this.id = id; }


    public void run() throws RuntimeException {

        int i = 0;

        while (i < REPETITIONS) {
            synchronized (lock) {
                shared = id;
                i++;
            }
        }

        System.out.printf( "Thread %d: i = %d%n", id, i );
    }


    public static void main( String [] args ) {

        Thread t1 = new Thread( new InterferenceChecker_WithSynchronizedBlock( 1 ) );
        Thread t2 = new Thread( new InterferenceChecker_WithSynchronizedBlock( 2 ) );

        t1.start();
        t2.start();
    }
}
