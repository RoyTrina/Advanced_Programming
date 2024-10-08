package Labs.Lab2.Solutions.Exercise2.Q1;

import java.util.concurrent.locks.ReentrantLock;

public class InterferenceChecker_WithReentrantLock implements Runnable {

    public static int shared;
    static final ReentrantLock reentrantLock = new ReentrantLock();
    static final int REPETITIONS = 1000 * 1000;

    public final int id;

    InterferenceChecker_WithReentrantLock(int id) {
        this.id = id;
    }


    public void run() {

        int i = 0;

        while (i < REPETITIONS) {
            reentrantLock.lock();
            try {
                shared = id;
                i++;
            } finally {
                reentrantLock.unlock();
            }
        }

        System.out.printf("Thread %d: i = %d%n", id, i);
    }


    public static void main(String[] args) {

        Thread t1 = new Thread(new InterferenceChecker_WithReentrantLock(1));
        Thread t2 = new Thread(new InterferenceChecker_WithReentrantLock(2));

        t1.start();
        t2.start();
    }
}
